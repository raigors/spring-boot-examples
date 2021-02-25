package com.github.spring.boot.retry.service;

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

public interface IRetryService {

    String retry(String id);

    String recover(Exception e, String id);
}
