package com.github.spring.boot.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.spring.boot.jackson.pojo.view.UserDetailView;
import com.github.spring.boot.jackson.pojo.view.UserSimpleView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 创建时间为 21:57 2019-04-22
 * 项目名称 spring-boot-jackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Setter
@ToString
public class JsonViewDTO {

    @JsonView(UserSimpleView.class)
    private String simple;

    @JsonView(UserDetailView.class)
    private String detail;

}
