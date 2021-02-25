package com.github.spring.boot.property.config;

import com.github.spring.boot.property.pojo.UserDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 创建时间为 15:12 2019-04-10
 * 项目名称 spring-boot-property
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "com.github")
public class ConfigProperty {

    private Map<String, String> map;

    private List<String> list;

    private UserDO user;

    private List<UserDO> users;
}
