package cn.merryyou.validator;

import cn.merryyou.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created on 2017/12/19 0019.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        log.info("MyConstraintValidator.initialize");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.hello("word!");
        log.info(o.toString());
        return true;
    }
}
