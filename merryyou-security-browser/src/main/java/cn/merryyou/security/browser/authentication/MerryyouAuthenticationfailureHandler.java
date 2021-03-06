package cn.merryyou.security.browser.authentication;

import cn.merryyou.security.core.support.SimpleResponse;
import cn.merryyou.security.core.properties.LoginType;
import cn.merryyou.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录失败处理
 * Created on 2017/12/21 0021.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component(value = "merryyouAuthenticationfailureHandler")
@Slf4j
//public class MerryyouAuthenticationfailureHandler implements AuthenticationFailureHandler {
public class MerryyouAuthenticationfailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        log.info("【MerryyouAuthenticationfailureHandler】 onAuthenticationFailure e={}");

        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());//服务器内部异常
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(e.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, e);
        }

    }
}
