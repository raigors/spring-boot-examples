package com.github.spring.boot.elasticsearch.repository.impl;

import com.github.spring.boot.elasticsearch.pojo.dto.FlowLogDTO;
import com.github.spring.boot.elasticsearch.repository.IFlowLogRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 * <p>
 * create in 2021/3/3 11:13 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Repository
public class FlowLogRepositoryImpl implements IFlowLogRepository {


    @Override
    public void findAll() {

    }

    private String[] indexs(FlowLogDTO flowLog){
        return null;
    }

}
