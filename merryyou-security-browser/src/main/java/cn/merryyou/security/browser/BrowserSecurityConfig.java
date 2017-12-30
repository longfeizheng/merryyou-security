package cn.merryyou.security.browser;

import cn.merryyou.security.core.properties.SecurityProperties;
import cn.merryyou.security.core.validate.code.ValidateCodeFilter;
import cn.merryyou.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 配置spring Security 默认的认证方式
 * Created on 2017/12/21 0021.  过滤器连
 * 过滤器：UsernamePasswordAuthenticationFilter  BasicAuthenticationFilter ExceptionTranslationFilter(引导登录页面) FilterSecurityInterceptor
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private AuthenticationSuccessHandler merryyouAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler merryyouAuthenticationfailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
       // tokenRepository.setCreateTableOnStartup(true);//启动时，自动创建表用于记录用户名和token 一一对应
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter filter = new ValidateCodeFilter();
//        http.httpBasic()
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()//form 表单
                    .loginPage("/authentication/require")//跳转自定义登录页面
                    .loginProcessingUrl("/authentication/form")//使spring security处理自定义登录地址，
                    .successHandler(merryyouAuthenticationSuccessHandler)//登录成功使用自定义处理返回结果
                    .failureHandler(merryyouAuthenticationfailureHandler)//登录失败处理
                    .and()
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()//授权
                .antMatchers("/authentication/require", "/code/image", securityProperties.getBrowser().getLoginPage()).permitAll()//访问当前URL不需要身份认证
                .anyRequest()//任何请求
                .authenticated()//都需要身份认证
                .and()
                .csrf().disable();//跨站伪造
    }

    /**
     * 相同密码每次加密出的密码不一样（随机生成salt）
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
