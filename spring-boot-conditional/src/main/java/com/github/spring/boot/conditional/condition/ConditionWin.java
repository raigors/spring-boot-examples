package com.github.spring.boot.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * <p>
 * 创建时间为 下午1:02-2019/1/11
 * 项目名称 SpringBootConditional
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


public class ConditionWin implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return true;
    }

}
