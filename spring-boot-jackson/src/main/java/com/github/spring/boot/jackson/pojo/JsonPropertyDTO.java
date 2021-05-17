package com.github.spring.boot.jackson.pojo;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JsonPropertyDTO {

    /**
     * 可以设置访问
     * access = JsonProperty.Access.READ_ONLY
     * access = JsonProperty.Access.READ_WRITE
     */
    @JsonProperty(value = "subName", required = false, index = 1, defaultValue = "123", access = JsonProperty.Access.READ_WRITE)
    private String name;

    @JsonInclude
    private String note;

    /**
     * {@link JsonIgnore} 可以让这个字段不参与反序列化
     * 为反序列化期间要接受的属性定义一个或多个替代名称
     */
    @JsonAlias({"pass1", "pass2"})
    private String pass;

}
