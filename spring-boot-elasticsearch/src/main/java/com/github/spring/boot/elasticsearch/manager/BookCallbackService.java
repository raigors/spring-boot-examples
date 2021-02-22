package com.github.spring.boot.elasticsearch.manager;

import com.github.spring.boot.elasticsearch.pojo.orm.BookDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.data.elasticsearch.core.event.AfterSaveCallback;
import org.springframework.data.elasticsearch.core.event.BeforeConvertCallback;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

/**
 * TODO
 * <p>
 * create in 2021/2/22 3:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Order(1)
@Component
public class BookCallbackService implements BeforeConvertCallback<BookDO>, AfterSaveCallback<BookDO> {

    @Override
    public BookDO onBeforeConvert(BookDO entity, IndexCoordinates index) {
        log.info("onBeforeConvert - {} - {}", entity.toString(), index.getIndexNames());
        return entity;
    }

    @Override
    public BookDO onAfterSave(BookDO entity, IndexCoordinates index) {
        log.info("onAfterSave - {} - {}", entity.toString(), index.getIndexNames());
        return entity;
    }
}
