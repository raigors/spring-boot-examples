//package com.github.spring.boot.elasticsearch.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.ReadingConverter;
//import org.springframework.data.convert.WritingConverter;
//import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
//import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * TODO
// * <p>
// * create in 2021/2/20 5:00 下午
// *
// * @author shishaodong
// * @version 0.0.1
// */
//
//@Configuration
//public class ElasticsearchConfiguration extends ElasticsearchConfigurationSupport {
//
//    @Bean
//    @Override
//    public EntityMapper entityMapper() {
//        ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(elasticsearchMappingContext(), null);
//        entityMapper.setConversions(elasticsearchCustomConversions());
//        return entityMapper;
//    }
//
//    /**
//     * conversions for LocalDateTime
//     *
//     * @return
//     */
//    @Bean
//    @Override
//    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//        List<Converter<?, ?>> converters = new ArrayList<>();
//        converters.add(DateToLocalDateTimeConverter.INSTANCE);
//        converters.add(LongToLocalDateTimeConverter.INSTANCE);
//        return new ElasticsearchCustomConversions(converters);
//    }
//
//    @ReadingConverter
//    enum LongToLocalDateTimeConverter implements Converter<Long, LocalDateTime> {
//
//        INSTANCE;
//
//        @Override
//        public LocalDateTime convert(Long source) {
//            return Instant.ofEpochMilli(source).atZone(ZoneId.systemDefault()).toLocalDateTime();
//        }
//    }
//
//    @WritingConverter
//    enum DateToLocalDateTimeConverter implements Converter<Date, LocalDateTime> {
//
//        INSTANCE;
//
//        @Override
//        public LocalDateTime convert(Date date) {
//            Instant instant = date.toInstant();
//            return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
//        }
//    }
//
//
//}