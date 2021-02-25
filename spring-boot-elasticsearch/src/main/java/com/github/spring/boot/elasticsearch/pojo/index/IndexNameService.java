package com.github.spring.boot.elasticsearch.pojo.index;

import org.springframework.stereotype.Service;

/**
 * 自动生成集合名词
 * <p>
 * create in 2021/2/22 3:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service("index")
@SuppressWarnings("unused")
public class IndexNameService {

    public String getName() {
//        return "user_info-" + DateTime.now().toString("yyyy-MM-dd_HH_mm");
        return "user_info";
    }

}
