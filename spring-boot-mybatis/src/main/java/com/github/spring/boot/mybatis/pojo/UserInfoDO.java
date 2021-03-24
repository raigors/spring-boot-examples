package com.github.spring.boot.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-12-03 14:39
 * @since 1.0
 */

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "user_info")
public class UserInfoDO implements Serializable {

    private static final long serialVersionUID = -200618573669722274L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Integer age;


}
