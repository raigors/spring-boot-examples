package com.github.spring.boot.elasticsearch.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * create in 2021/3/4 4:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Getter
@Setter
@ToString
public class FlowLog2DTO {

    private Object term;

    private Object range;

    private Object match;

    //....

    @Override
    public String toString() {
        return "FlowLog2DTO{}";
    }
}
