/**
 * 
 */
package cn.merryyou.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @author zhailiang
 *
 */
public interface SocialAuthenticationFilterPostProcessor {
	
	void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
