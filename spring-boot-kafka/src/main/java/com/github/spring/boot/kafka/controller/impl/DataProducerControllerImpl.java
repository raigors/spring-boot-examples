package com.github.spring.boot.kafka.controller.impl;

import com.github.spring.boot.kafka.controller.IDataProducerController;
import com.github.spring.boot.kafka.pojo.ResultVO;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import com.github.spring.boot.kafka.service.DataProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/3/15 10:23 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
public class DataProducerControllerImpl implements IDataProducerController {

    @Resource
    private DataProducerService producerService;

    @PostMapping("/message1")
    @Override
    public ResultVO<String> dispatchMessage1(@RequestBody UserAuditLogDTO message) {
        return ResultVO.success(producerService.dispatchMessage(message));
    }

}
