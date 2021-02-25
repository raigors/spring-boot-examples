package com.github.spring.boot.filter.config;


import com.github.spring.boot.filter.filter.TimeFilter;
import com.google.common.collect.Lists;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:44 2019/12/7
 * 项目名称 spring-boot-filter
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class FilterRegisterConfig {

    /**
     * 使用这种方式可以制定 URL 过滤器生效
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<Filter> getFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        TimeFilter filter = new TimeFilter();
        registrationBean.setFilter(filter);
        List<String> urls = Lists.newArrayList("/test2");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

}
