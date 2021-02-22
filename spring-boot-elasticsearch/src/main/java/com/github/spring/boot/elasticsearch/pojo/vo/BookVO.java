package com.github.spring.boot.elasticsearch.pojo.vo;
import org.xmlbeam.annotation.XBRead;
import org.springframework.data.web.JsonPath;
import org.springframework.data.web.ProjectedPayload;

/**
 * TODO
 * <p>
 * create in 2021/2/20 5:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ProjectedPayload
public interface BookVO {

    @XBRead("//id")
    @JsonPath("$..id")
    String getId();

    @XBRead("//name")
    @JsonPath("$.name")
    String getName();

    @XBRead("//desc")
    @JsonPath("$.desc")
    String getDesc();

}
