package com.github.spring.boot.elasticsearch.pojo.index;

import org.springframework.stereotype.Service;

/**
 * TODO
 * <p>
 * create in 2021/2/22 3:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service("index")
public class IndexNameService {

    public String getName() {
//        return DateTime.now().toString("yyyy-MM-dd_HH_mm");
        return "book";
    }

}
