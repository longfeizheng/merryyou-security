package cn.merryyou.security.authentication.app;

import cn.merryyou.security.core.social.MerryyouSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 所有容器在bean初始化之前和之后都会调用这里面的两个方法
 * Created on 2017/12/31 0031.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
public class SpringSocialConfigurerPostProcesor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(StringUtils.equals(beanName,"merryyouSocialSecurityConfig")){
            MerryyouSpringSocialConfigurer merryyouSpringSocialConfigurer = (MerryyouSpringSocialConfigurer)bean;
            merryyouSpringSocialConfigurer.setFilterProcessesUrl("/social/signUp");
            return merryyouSpringSocialConfigurer;
        }
        return bean;
    }
}
