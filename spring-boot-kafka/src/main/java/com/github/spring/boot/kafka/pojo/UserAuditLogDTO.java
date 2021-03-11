package com.github.spring.boot.kafka.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * TODO
 * <p>
 * create in 2021/3/10 3:44 下午
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
public class UserAuditLogDTO {

    private String username;

    private String ip;

    private Integer age;

    private String userAgent;

    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date accessDate;


}
