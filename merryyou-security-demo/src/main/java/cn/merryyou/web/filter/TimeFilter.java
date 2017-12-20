package cn.merryyou.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
//@Component
@Slf4j
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("【TimeFilter】 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("【TimeFilter】 doFilter start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("【TimeFilter】 耗时time={}", new Date().getTime() - start);
        log.info("【TimeFilter】 doFilter stop");
    }

    @Override
    public void destroy() {
        log.info("【TimeFilter】 destroy");
    }
}
