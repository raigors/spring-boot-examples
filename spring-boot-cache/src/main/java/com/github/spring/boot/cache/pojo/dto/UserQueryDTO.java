package com.github.spring.boot.cache.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * 查询用户条件
 * <p>
 * create in 2021/2/7 5:15 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@ToString
public class UserQueryDTO {

    private String name;

    private String phone;

    private Integer age;

    public String getName() {
        return StringUtils.isEmpty(name) ? null : name + "%";
    }

    public String getPhone() {
        return StringUtils.isEmpty(phone) ? null : phone + "%";
    }
}
