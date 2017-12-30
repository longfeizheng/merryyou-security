package cn.merryyou.security.core.properties;

import lombok.Data;

/**
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class SocialProperties {

    private QQProperties qq = new QQProperties();

    private String filterProcessesUrl = "/auth";
}
