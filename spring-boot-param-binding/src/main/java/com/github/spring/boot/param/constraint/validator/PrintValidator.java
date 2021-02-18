package com.github.spring.boot.param.constraint.validator;

import com.github.spring.boot.param.constraint.annotation.Print;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * TODO
 * <p>
 * create in 2021/2/10 11:12 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class PrintValidator implements ConstraintValidator<Print, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        log.info("JSR303 ------------------ {}", s);
        return true;
    }
}