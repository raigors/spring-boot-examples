package com.github.spring.boot.elasticsearch.pojo.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 * <p>
 * create in 2021/2/23 3:05 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
public class BookBO {

    private String author;

    private String title;

    private String publisher;

    private String genre;

}
