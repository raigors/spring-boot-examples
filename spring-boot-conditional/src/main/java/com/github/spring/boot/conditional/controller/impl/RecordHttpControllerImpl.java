package com.github.spring.boot.conditional.controller.impl;

import com.github.spring.boot.conditional.controller.IRecordController;
import com.github.spring.boot.conditional.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/9 5:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Controller
public class RecordHttpControllerImpl implements IRecordController {

    @PostMapping("/list")
    @Override
    public void recordList(@RequestBody List<Person> list) {

    }
}
