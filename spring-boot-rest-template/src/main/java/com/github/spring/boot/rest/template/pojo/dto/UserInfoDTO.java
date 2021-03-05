package com.github.spring.boot.rest.template.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/3/5 5:14 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = -553815374342351987L;

    private String username;

    private Integer age;
}
