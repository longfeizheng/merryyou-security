package cn.merryyou.security.core.social.weixin.api;

/**
 * Created on 2017/12/31 0031.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);
}
