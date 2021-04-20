package com.github.spring.boot.kafka.config.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 分区器
 * <p>
 * create in 2021/4/20 5:19 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class UserAuditLogPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        log.info("进入分区器");
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
