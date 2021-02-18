package com.github.spring.boot.param.constraint.annotation;

import com.github.spring.boot.param.constraint.validator.PrintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 * <p>
 * create in 2021/2/10 11:12 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@Constraint(validatedBy = {PrintValidator.class})
public @interface Print {

    String value() default "";

    String message() default "公司手机号不能重复";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}