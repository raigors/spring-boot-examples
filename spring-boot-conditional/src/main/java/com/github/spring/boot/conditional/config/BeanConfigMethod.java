package com.github.spring.boot.conditional.config;

import com.github.spring.boot.conditional.condition.ConditionMac;
import com.github.spring.boot.conditional.condition.ConditionWin;
import com.github.spring.boot.conditional.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 创建时间为 下午1:03-2019/1/11
 * 项目名称 SpringBootConditional
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class BeanConfigMethod {

    /**
     * 只有当 {@link ConditionMac#matches}返回为 true 时,才生成这个对象
     *
     * @return Person
     */
    @Conditional(ConditionMac.class)
    @Bean("Person3")
    public Person getPersonMac() {
        return new Person("PersonMac");
    }

    /**
     * 只有当 {@link ConditionWin#matches}返回为 true 时,才生成这个对象
     *
     * @return Person
     */
    @Conditional(ConditionWin.class)
    @Bean("Person4")
    public Person getPersonWin() {
        return new Person("PersonWin");
    }

}
