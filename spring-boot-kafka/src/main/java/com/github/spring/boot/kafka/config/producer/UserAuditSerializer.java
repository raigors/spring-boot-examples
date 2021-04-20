package com.github.spring.boot.kafka.config.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;


/**
 * 用户数据序列化成 字节数组类
 * <p>
 * create in 2021/4/20 3:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class UserAuditSerializer implements Serializer<UserAuditLogDTO> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public byte[] serialize(String topic, UserAuditLogDTO data) {
        return OBJECT_MAPPER.writeValueAsBytes(data);
    }
}
