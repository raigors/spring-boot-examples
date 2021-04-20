package com.github.spring.boot.param.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * TODO
 * <p>
 * create in 2021/2/18 4:02 下午
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
public class UserInfoDTO<T> {

    @Resource
    @JsonIgnore
    private ObjectMapper objectMapper;

    private String name;

    @DateTimeFormat(pattern = "yyyyMMddHHmm")
    @JsonFormat(pattern = "yyyyMMddHHmm", timezone = "GMT+8")
    private LocalDateTime date;

    T data;

}
