package com.github.spring.boot.kafka.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
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
@NoArgsConstructor
@AllArgsConstructor
public class UserAuditLogDTO {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String username;

    private String ip;

    private Integer age;

    private String userAgent;

    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date accessDate;

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public String toString() {
        return OBJECT_MAPPER.writeValueAsString(this);
    }
}
