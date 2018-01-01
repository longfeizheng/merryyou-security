package cn.merryyou.security.rbac;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/1/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface RabcService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
