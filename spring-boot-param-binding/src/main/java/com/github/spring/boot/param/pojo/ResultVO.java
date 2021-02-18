package com.github.spring.boot.param.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 * <p>
 * create in 2021/2/18 4:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    private Integer status;

    private T data;

    public static <T> ResultVO<T> success(T t) {
        return ResultVO.<T>builder().data(t).status(200).build();
    }

}
