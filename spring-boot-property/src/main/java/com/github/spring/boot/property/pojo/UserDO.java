package com.github.spring.boot.property.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 创建时间为 20:49 2019-04-11
 * 项目名称 spring-boot-property
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString
public class UserDO {

    private String name;

    private Integer age;

    private Address address;

}
