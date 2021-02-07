package com.github.spring.boot.cache.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 统一返回接口数据
 * <p>
 * create in 2021/2/7 4:31 下午
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
public class ReturnVO<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -1876645671601863918L;

    private T data;

    private Integer status;

    private String message;

    public static <T extends Serializable> ReturnVO<T> success() {
        return ReturnVO.<T>builder().status(200).build();
    }

    public static <T extends Serializable> ReturnVO<T> success(T data) {
        return ReturnVO.<T>builder().status(200).data(data).build();
    }

    public static <T extends Serializable> ReturnVO<T> success(String message) {
        return ReturnVO.<T>builder().status(200).message(message).build();
    }

    public static <T extends Serializable> ReturnVO<T> success(T data, String message) {
        return ReturnVO.<T>builder().status(200).message(message).data(data).build();
    }
}
