package com.github.spring.boot.kafka.controller;

import com.github.spring.boot.kafka.pojo.ResultVO;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;

/**
 * TODO
 * <p>
 * create in 2021/3/15 10:23 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IDataProducerController {

    ResultVO<String> dispatchMessage1(UserAuditLogDTO message);

}
