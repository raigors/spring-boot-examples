package com.github.spring.boot.jackson.service;

import com.github.spring.boot.jackson.pojo.NginxConfDTO;

/**
 * TODO
 * <p>
 * create in 2021/5/13 4:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FunctionalInterface
public interface INginxConfService {

    /**
     * 生产 nginx 配置的具体逻辑
     *
     * @param nginxConf 数据库查询出来返回给调用方的转换对象
     */
    void generateConf(NginxConfDTO nginxConf);
}
