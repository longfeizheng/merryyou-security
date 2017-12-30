package cn.merryyou.security.core.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2017/12/21 0021.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)//使配置读取器生效
public class SecurityCoreConfig {
}
