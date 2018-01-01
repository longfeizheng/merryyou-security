package cn.merryyou.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * Created on 2018/1/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface AuthorizeConfigProvider {

    boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry configurer);
}
