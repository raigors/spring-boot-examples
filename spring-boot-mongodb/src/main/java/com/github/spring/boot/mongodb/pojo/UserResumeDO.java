package com.github.spring.boot.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 * <p>
 * create in 2021/4/28 4:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
@Document(collection = "user_resume")
@CompoundIndex(name = "idx_age_created_date", def = "{'age':1,'createdDate':1}")
@CompoundIndex(name = "idx_region_age", def = "{'region':1,'age':1}")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResumeDO implements Serializable {

    private static final long serialVersionUID = -6219948652527287888L;

    @Id
    private String id;

    @Indexed
    private String username;

    private String mobile;

    private Integer age;

    private String region;

    private String email;

    private String note;

    private Integer salary;

    /**
     * 创建 ttl 的集合, 创建改集合时需要设置 ttl 字段, 特别要注意, 该字段 存入的数据类型为 Date
     * 用来设置集合中 文档到期的秒数。如果没有设置，则默认为-1
     * 60 秒之后过期
     */
    @Indexed(name = "IDX_TTL", expireAfterSeconds = 60)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expire;

    @CreatedDate
    @Field("created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    @LastModifiedDate
    @Field("last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate;

    /**
     * 被 {@link Transient} 标记的字段将不会保存到数据库中
     */
    @Transient
    private Long temp;

    /**
     * 版本号
     */
    @Version
    private Long version;
}
