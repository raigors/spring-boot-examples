package com.github.spring.boot.mongodb.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * create in 2021/4/28 4:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Data
@ToString
public class UserResumeResultDTO {
    private String username;
    private Integer sum;

}
