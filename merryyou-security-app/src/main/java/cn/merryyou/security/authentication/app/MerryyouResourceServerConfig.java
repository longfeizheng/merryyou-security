package cn.merryyou.security.authentication.app;

import cn.merryyou.security.authentication.app.authnentication.openid.OpenIdAuthenticationSecurityConfig;
import cn.merryyou.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import cn.merryyou.security.core.authorize.AuthorizeConfigManager;
import cn.merryyou.security.core.properties.SecurityConstants;
import cn.merryyou.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created on 2017/12/23 0023.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Configuration
@EnableResourceServer
public class MerryyouResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    protected AuthenticationSuccessHandler merryyouAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler merryyouAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer merryyouSocialSecurityConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
                .successHandler(merryyouAuthenticationSuccessHandler)
                .failureHandler(merryyouAuthenticationFailureHandler);
        http//.apply(validateCodeSecurityConfig)
            //    .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(merryyouSocialSecurityConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                .csrf().disable();
            authorizeConfigManager.config(http.authorizeRequests());
    }
}
