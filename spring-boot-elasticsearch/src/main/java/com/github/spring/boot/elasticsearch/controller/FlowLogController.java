package com.github.spring.boot.elasticsearch.controller;

import com.github.spring.boot.elasticsearch.pojo.dto.FlowLogDTO;
import com.github.spring.boot.elasticsearch.pojo.orm.FlowLogDO;
import com.github.spring.boot.elasticsearch.repository.IFlowLogBasicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/3/3 10:53 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class FlowLogController {

    @Resource
    private IFlowLogBasicRepository repository;

    @PostMapping("/log")
    public Page<FlowLogDO> list(@RequestBody FlowLogDTO flowLog,
                                @PageableDefault(page = 0, size = 5, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable) {
        log.info("分页信息:{}", pageable.toString());
        return repository.findAllByConditions(flowLog.getQuery(), pageable);
    }

}
