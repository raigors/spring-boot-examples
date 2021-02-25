package com.github.spring.boot.controller.advice.exception;

import com.github.spring.boot.controller.advice.pojo.UserDO;
import lombok.Data;

/**
 * <p>
 * 创建时间为 09:53 2019-04-27
 * 项目名称 spring-boot-controlleradvice
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Data
public class UserException  extends RuntimeException {

    private UserDO userDO;

    public UserException(UserDO userDO) {
        this.userDO = userDO;
    }

}
