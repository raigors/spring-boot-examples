package com.github.spring.boot.elasticsearch.pojo.index;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自动生成集合名词
 * <p>
 * create in 2021/2/22 3:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service("index")
public class IndexNameService {

    @Resource
    private ObjectProvider<HttpServletRequest> provider;

    public String getName() {
        return index();
    }

    private String index() {
        AtomicReference<String> reference = new AtomicReference<>("index");
        provider.ifAvailable(httpServletRequest -> {
            Object index = httpServletRequest.getAttribute("ES_INDEX");
            if (ObjectUtils.isNotEmpty(index)) {
                reference.set((String) index);
            }
        });
        String index = reference.get();
        log.info("索引名:" + index);
        return index;
    }

}
