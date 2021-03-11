package com.github.spring.boot.retry.service.impl;

import com.github.spring.boot.retry.service.IRetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午3:32 2019/11/26
 * 项目名称 spring-boot-retry
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Service
public class RetryServiceImpl implements IRetryService {

    private static final String REMOTE_URL = "http://www.shishaodong.com/";

    @Resource
    private RestTemplate restTemplate;

    @Retryable(
            value = Exception.class,
            maxAttempts = 2,
            backoff = @Backoff(delay = 1000L, multiplier = 1.5),
            listeners = {"RemoteRemoteListener"}
    )
    @Override
    public String retry(String id) {
        log.info("进入了 retry 方法 id:" + id);
        return restTemplate.getForObject(REMOTE_URL + id, String.class);
    }

    /**
     * 当进入异常时, 会尝试2次, 2次都不成功时会进入这个方法, 并返回结果
     *
     * @param e  异常信息
     * @param id retry参数
     * @return String
     */
    @Recover
    @Override
    public String recover(Exception e, String id) {
        log.warn("进入了 recover 方法:" + id);
        return "recover";
    }

}
