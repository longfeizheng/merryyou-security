package cn.merryyou.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created on 2017/12/21 0021.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "merryyou.security")//配置读取器，会读取application.yml中以merryyou.security开头的配置
public class SecurityProperties {

    /**
     * 浏览器环境配置
     */
    private BrowserProperties browser = new BrowserProperties();
    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 社交配置
     */
    private SocialProperties social = new SocialProperties();

    private OAuth2Properties oauth2= new OAuth2Properties();
}
