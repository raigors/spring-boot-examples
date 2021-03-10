package com.github.spring.boot.kafka.controller;

import com.github.spring.boot.kafka.pojo.ResultVO;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/3/10 3:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IDataEntryController {

    ResultVO<Void> saveMessage(UserAuditLogDTO message);

    ResultVO<Void> saveAllMessage(List<UserAuditLogDTO> list);

}
