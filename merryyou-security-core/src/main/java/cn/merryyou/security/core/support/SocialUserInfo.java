package cn.merryyou.security.core.support;

import lombok.Data;

/**
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class SocialUserInfo {
    private String providerId;
    private String providerUserId;
    private String nickname;
    private String heading;

}
