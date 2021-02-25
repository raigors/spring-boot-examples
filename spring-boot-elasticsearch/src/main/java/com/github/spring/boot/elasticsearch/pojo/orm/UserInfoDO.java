package com.github.spring.boot.elasticsearch.pojo.orm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.spring.boot.elasticsearch.pojo.bo.BookBO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * \@Document(indexName = "#{\@index.getName()}", replicas = 0, refreshInterval = "-1")
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
@TypeAlias("UserInfoDO")
@Document(indexName = "#{@index.getName()}", replicas = 0, refreshInterval = "-1")
public class UserInfoDO {

    @Id
    private String id;

    private String username;

    private Integer age;

    private List<String> programmingLanguages;

    private String phoneNumber;

    private List<BookBO> books;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Field(type = FieldType.Date)
    private Date createDate;

    /**
     * The method that uses @DomainEvents can return either a single event instance or a collection of events.
     * It must not take any arguments.
     * The methods are called every time one of a
     * Spring Data repository’s save(…), saveAll(…), delete(…) or deleteAll(…)
     * methods are called.
     *
     * @return Collection
     */
    @DomainEvents
    UserInfoDO domainEvents() {
        // … return events you want to get published here
        return this;
    }

    /**
     * After all events have been published, we have a method annotated with @AfterDomainEventPublication.
     * You can use it to potentially clean the list of events to be published (among other uses).
     */
    @AfterDomainEventPublication
    void callbackMethod() {
        // … potentially clean up domain events list
    }
}