package cn.merryyou.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2017/12/19 0019.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
