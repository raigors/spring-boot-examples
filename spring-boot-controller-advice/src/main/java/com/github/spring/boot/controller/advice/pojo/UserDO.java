package com.github.spring.boot.controller.advice.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 创建时间为 09:52 2019-04-27
 * 项目名称 spring-boot-controlleradvice
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString
public class UserDO {

    @NotBlank
    private String name;

    private String pass;

}
