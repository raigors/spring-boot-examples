package com.github.spring.boot.async.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 20:05 2019-04-27
 * 项目名称 spring-boot-async
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@ToString
public class UserDO implements Serializable {

    private static final long serialVersionUID = -1806319620082171204L;

    private String name;

    private String pass;

}
