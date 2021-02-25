package com.github.spring.boot.conditional.config;

import com.github.spring.boot.conditional.condition.ConditionClass;
import com.github.spring.boot.conditional.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 满足当前条件,这个类中配置的所有的 bean 注册才能生效
 *
 * <p>
 * 创建时间为 下午1:11-2019/1/11
 * 项目名称 SpringBootConditional
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Configuration
@Conditional(ConditionClass.class)
public class BeanConfigClass {

    @Bean("Person1")
    public Person getPerson1() {
        return new Person("P11");
    }

    @Bean("Person2")
    public Person getPerson2() {
        return new Person("P12");
    }

}
