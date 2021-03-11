package com.github.spring.boot.param.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.boot.param.constraint.annotation.Print;
import com.github.spring.boot.param.pojo.ResultVO;
import com.github.spring.boot.param.pojo.SpringVO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * TODO
 * <p>
 * create in 2021/2/9 3:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class PathVariableController {

    private final ObjectMapper objectMapper;

    @GetMapping("/index/{message}")
    public SpringVO index(@RequestHeader("User-Agent") String agent, @PathVariable String message, @Print String aaa) {
        log.info("RestController - PathVariableController");
        return SpringVO.builder().agent(agent).message(message + "  " + aaa).build();
    }

    @SneakyThrows(JsonProcessingException.class)
    @GetMapping("/path/many/{ids}")
    public ResultVO<Set<Long>> many(@PathVariable("ids") Set<Long> ids) {
        log.error("路径获取多个参数:{}", objectMapper.writeValueAsString(ids));
        return ResultVO.success(ids);
    }

}
