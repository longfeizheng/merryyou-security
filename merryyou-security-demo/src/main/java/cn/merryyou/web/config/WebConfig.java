package cn.merryyou.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private TimeInterceptor timeInterceptor;
//
//    @Bean
//    public FilterRegistrationBean timeFilter() {
//
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        TimeFilter timeFilter = new TimeFilter();
//        registrationBean.setFilter(timeFilter);
//        List<String> urls = new ArrayList<>();
//        urls.add("/*");
//        registrationBean.setUrlPatterns(urls);
//        return registrationBean;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
//    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //拦截异步请求
//        configurer.registerCallableInterceptors();
//        configurer.registerDeferredResultInterceptors();
    }
}
