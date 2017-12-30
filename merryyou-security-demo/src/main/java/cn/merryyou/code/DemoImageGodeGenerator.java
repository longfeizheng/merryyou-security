package cn.merryyou.code;

import cn.merryyou.security.core.validate.code.ValidateCode;
import cn.merryyou.security.core.validate.code.ValidateCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 以增量的方式处理变化！
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
//@Component("imageValidateCodeGenerator")
@Slf4j
public class DemoImageGodeGenerator implements ValidateCodeGenerator {
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        log.info("【DemoImageGodeGenerator】 generate 生成验证码");
        return null;
    }
}
