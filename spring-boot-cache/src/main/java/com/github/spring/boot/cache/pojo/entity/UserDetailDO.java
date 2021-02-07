package com.github.spring.boot.cache.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户 ORM 类
 * <p>
 * create in 2021/2/7 4:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "user_detail",
        uniqueConstraints = {@UniqueConstraint(name = "uk_name", columnNames = {"name"})},
        indexes = {@Index(name = "idx_phone", columnList = "phone")}
)
@EntityListeners(AuditingEntityListener.class)
public class UserDetailDO implements Serializable {

    private static final long serialVersionUID = -8116446033357952120L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String phone;

    @Range(min = 0, max = 125)
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private Date lastModifiedDate;

}
