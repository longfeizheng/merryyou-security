package cn.merryyou.security;

import cn.merryyou.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/1/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Order(Integer.MAX_VALUE)
public class DemoAuthorizeConfiguProvider implements AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry configurer) {
//        configurer.antMatchers("/user/*").hasRole("ADMIN");
        configurer.anyRequest().access("@rbacService.hasPermission(request,authentication)");
    }
}
