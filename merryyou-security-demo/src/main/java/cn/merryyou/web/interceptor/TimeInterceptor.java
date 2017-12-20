package cn.merryyou.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        log.info("【TimeInterceptor】 preHandle");

        log.info("【TimeInterceptor】 handler={}", ((HandlerMethod) handler).getBean().getClass().getName());
        log.info("【TimeInterceptor】 handler={}", ((HandlerMethod) handler).getMethod().getName());
        httpServletRequest.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long start = (Long) httpServletRequest.getAttribute("startTime");
        log.info("【TimeInterceptor】 耗时={}", new Date().getTime() - start);
        log.info("【TimeInterceptor】 ex={}", e);
        log.info("【TimeInterceptor】 afterCompletion");
    }
}
