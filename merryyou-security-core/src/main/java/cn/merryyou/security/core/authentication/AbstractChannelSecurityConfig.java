package cn.merryyou.security.core.authentication;

import cn.merryyou.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler merryyouAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler merryyouAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
                .successHandler(merryyouAuthenticationSuccessHandler)
                .failureHandler(merryyouAuthenticationFailureHandler);
    }
}
