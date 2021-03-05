package com.github.spring.boot.rest.template.pojo.vo;

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
 * create in 2021/3/5 5:11 下午
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
public class ReturnVO<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 8703959550997666187L;

    private Integer status;

    private String message;

    private T data;

    public static <T extends Serializable> ReturnVO<T> success() {
        return ReturnVO.<T>builder().message("执行成功").status(200).build();
    }

}
