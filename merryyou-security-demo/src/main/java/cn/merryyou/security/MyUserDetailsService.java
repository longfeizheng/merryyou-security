package cn.merryyou.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created on 2017/12/21 0021.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * AuthorityUtils将字符串转换成权限集合
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【MyUserDetailsService】 loadUserByUsername 表单登录用户名  username={}", username);

        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("【MyUserDetailsService】 loadUserByUserId 社交登录用户ID  userId={}", userId);

        return buildUser(userId);

    }

    private SocialUserDetails buildUser(String userId) {
        return new SocialUser(userId, passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }
}
