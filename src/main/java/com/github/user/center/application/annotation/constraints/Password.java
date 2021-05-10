package com.github.user.center.application.annotation.constraints;

import com.github.user.center.application.annotation.constraints.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 * <p>
 * create in 2021/5/10 8:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default "密码不符合规范";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
