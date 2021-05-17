package com.github.spring.boot.jackson.pojo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * 将 Set 中字符串 以 | 拼接
 *
 * @author 石少东
 * @date 2020-10-23 15:31
 * @since 1.0
 */


public class MobileSerializer extends JsonSerializer<Set<String>> {

    @Override
    public void serialize(Set<String> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String res = StringUtils.join(Arrays.stream(value.toArray()).distinct().toArray(), "|");
        gen.writeObject(res);
    }
}
