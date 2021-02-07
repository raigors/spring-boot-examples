package com.github.spring.boot.cache.pojo.dto;

import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户DTO
 * <p>
 * create in 2021/2/7 4:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO extends UserCreateDTO implements Serializable {

    private static final long serialVersionUID = 3146647083950952120L;

    private Long id;

    @Override
    public UserDetailDO getUserDetailEntity() {
        UserDetailDO user = super.getUserDetailEntity();
        user.setId(id);
        return user;
    }

}
