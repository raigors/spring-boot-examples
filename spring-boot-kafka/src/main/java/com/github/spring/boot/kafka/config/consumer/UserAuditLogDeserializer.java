package com.github.spring.boot.kafka.config.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

/**
 * TODO
 * <p>
 * create in 2021/3/10 4:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class UserAuditLogDeserializer implements Deserializer<UserAuditLogDTO> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows({IOException.class})
    @Override
    public UserAuditLogDTO deserialize(String topic, byte[] data) {
        return (null == data) ? null : OBJECT_MAPPER.readValue(data, UserAuditLogDTO.class);
    }

}
