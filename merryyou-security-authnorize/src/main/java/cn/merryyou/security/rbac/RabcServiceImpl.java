package cn.merryyou.security.rbac;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2018/1/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component("rbacService")
public class RabcServiceImpl implements RabcService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        Boolean hasPermission = false;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            //读取用户所拥有权限所有的URL
            Set<String> urls = new HashSet<>();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return false;
    }
}
