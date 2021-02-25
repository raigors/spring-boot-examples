package com.github.spring.boot.conditional.config;

import com.github.spring.boot.conditional.condition.ConditionClass;
import com.github.spring.boot.conditional.pojo.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
public class BeanConfigProperty {

    @Bean("Person5")
    @ConditionalOnMissingBean
    public Person getPerson3() {
        return new Person("P3");
    }

    @Bean("Person6")
    @ConditionalOnProperty(name = "name.key1")
    public Person getPerson4() {
        return new Person("P4");
    }

    @Bean("Person7")
    @ConditionalOnProperty(name = "name.key2", havingValue = "123")
    public Person getPerson5() {
        return new Person("P5");
    }

    @Bean("Person8")
    @ConditionalOnProperty(prefix = "name", name = "key3", havingValue = "123")
    public Person getPerson6() {
        return new Person("P6");
    }

    @Bean("Person9")
    @ConditionalOnProperty(prefix = "name", name = {"key4", "key5"})
    public Person getPerson7() {
        return new Person("P7");
    }

    @Bean("Person10")
    @ConditionalOnProperty(prefix = "name", name = {"key6", "key7"}, havingValue = "123")
    public Person getPerson8() {
        return new Person("P8");
    }

    @Bean("Person11")
    @ConditionalOnProperty(prefix = "name", name = {"key8", "key9"}, havingValue = "123", matchIfMissing = true)
    public Person getPerson9() {
        return new Person("P9");
    }


}
