package cn.merryyou.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class QQProperties extends SocialProperties {

    private String providerId = "qq";
}
