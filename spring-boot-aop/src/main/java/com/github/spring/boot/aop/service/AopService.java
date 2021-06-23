package com.github.spring.boot.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TODO
 * <p>
 * create in 2021/6/22 1:36 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service("shishaodongBean")
public class AopService {

    public String hello(String data){
        return data;
    }

}
