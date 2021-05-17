package com.github.spring.boot.jackson.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.spring.boot.jackson.pojo.serializer.MobileDeserializer;
import com.github.spring.boot.jackson.pojo.serializer.MobileSerializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * @author 石少东
 * @date 2020-10-23 15:18
 * @since 1.0
 */

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SerializationDTO {

    String username;

    @JsonSerialize(using = MobileSerializer.class)
    @JsonDeserialize(using = MobileDeserializer.class)
    Set<String> mobiles;

}
