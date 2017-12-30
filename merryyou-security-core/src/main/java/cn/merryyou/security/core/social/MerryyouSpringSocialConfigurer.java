package cn.merryyou.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class MerryyouSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public MerryyouSpringSocialConfigurer (String filterProcessesUrl){
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
        return super.postProcess(object);
    }
}
