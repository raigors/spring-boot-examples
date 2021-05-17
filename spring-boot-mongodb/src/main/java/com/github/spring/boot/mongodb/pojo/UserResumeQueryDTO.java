package com.github.spring.boot.mongodb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

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
@NoArgsConstructor
@AllArgsConstructor
public class UserResumeQueryDTO {

    private Date startDate;

    private Date endDate;


}
