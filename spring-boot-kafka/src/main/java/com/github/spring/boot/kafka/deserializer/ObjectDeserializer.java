//package com.github.spring.boot.kafka.deserializer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.common.header.Headers;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.util.Map;
//
///**
// * TODO
// * <p>
// * create in 2021/3/10 4:13 下午
// *
// * @author shishaodong
// * @version 0.0.1
// */
//
//@Slf4j
//public class ObjectDeserializer<T> implements Deserializer<T> {
//
//    private String encoding = "UTF8";
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public T deserialize(String topic, byte[] data) {
//        return (null == data) ? null : objectMapper.readValue(data, ??? );
//    }
//
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
//        Object encodingValue = configs.get(propertyName);
//        if (encodingValue == null) {
//            encodingValue = configs.get("deserializer.encoding");
//        }
//        if (encodingValue instanceof String) {
//            encoding = (String) encodingValue;
//        }
//    }
//
//    @Override
//    public T deserialize(String topic, Headers headers, byte[] data) {
//        return null;
//    }
//
//    @Override
//    public void close() {
//
//    }
//}
