package com.github.spring.boot.jackson.service;

import com.github.spring.boot.jackson.pojo.NginxConfDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TODO
 * <p>
 * create in 2021/5/13 3:59 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
public class NginxConfServiceImpl implements INginxConfService {

    @Override
    public void generateConf(NginxConfDTO nginxConf) {
        // do something
    }

}
