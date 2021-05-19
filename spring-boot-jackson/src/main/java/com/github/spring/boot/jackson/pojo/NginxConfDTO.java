package com.github.spring.boot.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.spring.boot.jackson.service.INginxConfService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * create in 2021/5/13 3:56 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NginxConfDTO {

    Integer version;

    String nginxConf;

    @JsonProperty
    public String getName() {
        return "test_name";
    }

    @JsonProperty
    public Integer getVersion() {
        return version + 11;
    }

    @JsonProperty
    public String getNginxConf() {
        return nginxConf + " , do something";
    }

    /**
     * 方法 1
     * 加上 {@link JsonValue} 视图只会返回这个方法的返回.
     *
     * @return 配置文件
     */
    @JsonValue
    public String getNginxConfResult() {
        // do something
        return nginxConf;
    }

    /**
     * 方法 2
     * 创建配置
     *
     * @param service 创建配置文件的服务
     */
    public void generateConf(INginxConfService service) {
        service.generateConf(this);
    }

}
