package com.github.spring.boot.elasticsearch.pojo.orm;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * TODO
 * <p>
 * create in 2021/2/18 4:15 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
@Document(indexName = "book", shards = 1, replicas = 0, refreshInterval = "-1", indexStoreType = "fs")
public class BookDO {

    @Id
    private String id;

    private String name;

    private String desc;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Field(type = FieldType.Date)
    private Date createDate;

}