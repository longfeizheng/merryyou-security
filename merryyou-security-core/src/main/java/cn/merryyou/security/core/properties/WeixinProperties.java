package cn.merryyou.security.core.properties;
import org.springframework.boot.autoconfigure.social.SocialProperties;

import lombok.Data;

/**
 * Created on 2017/12/31 0031.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class WeixinProperties extends SocialProperties {

    private String providerId = "weixin";

}
