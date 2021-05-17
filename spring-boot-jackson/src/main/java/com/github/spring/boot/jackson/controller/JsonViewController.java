package com.github.spring.boot.jackson.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.spring.boot.jackson.pojo.JsonViewDTO;
import com.github.spring.boot.jackson.pojo.view.UserDetailView;
import com.github.spring.boot.jackson.pojo.view.UserSimpleView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 21:54-2019-04-22
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class JsonViewController {

    @GetMapping("simple")
    @JsonView(UserSimpleView.class)
    public JsonViewDTO getSimple() {
        JsonViewDTO jsonViewDTO = getJsonViewDO();
        log.info("返回数据:{}", jsonViewDTO);
        return jsonViewDTO;
    }

    @GetMapping("detail")
    @JsonView(UserDetailView.class)
    public JsonViewDTO getDetail() {
        JsonViewDTO jsonViewDTO = getJsonViewDO();
        log.info("返回数据:{}", jsonViewDTO);
        return jsonViewDTO;
    }

    private JsonViewDTO getJsonViewDO() {
        JsonViewDTO jsonViewDTO = new JsonViewDTO();
        jsonViewDTO.setSimple("Message:Simple");
        jsonViewDTO.setDetail("Message:Detail");
        return jsonViewDTO;
    }

}
