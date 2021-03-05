package com.github.spring.boot.elasticsearch.pojo.dto;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.github.spring.boot.elasticsearch.pojo.common.IndexPrefix.INDEX_PREFIX;

/**
 * TODO
 * <p>
 * create in 2021/3/3 10:57 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Getter
@Setter
@ToString
public class FlowLogDTO implements Serializable {

    private static final long serialVersionUID = -585018989197102403L;

    private static final String DATE_MONTH = "yyyy-MM-dd";

    @DateTimeFormat(pattern = DATE_MONTH)
    private Date startTime;

    @DateTimeFormat(pattern = DATE_MONTH)
    private Date endTime;

    private String query;

    public String getQuery() {
        initIndexes();
        return StringUtils.isBlank(query) ? "{\"match_all\":{}}" : query;
    }

    /**
     * 根据查询条件获取 index 数组
     */
    private void initIndexes() {
        List<String> list = Lists.newArrayList();
        DateTime startDate = new DateTime(startTime.getTime());
        DateTime endDate = new DateTime(endTime.getTime());
        while (!startDate.isAfter(endDate)) {
            list.add(INDEX_PREFIX + startDate.toString(DATE_MONTH));
            startDate = startDate.plusDays(1);
        }
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        request.setAttribute("ES_INDEX", join(list));
    }

    private String join(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
            stringBuilder.append(",");
        }
        return StringUtils.removeEnd(stringBuilder.toString(), ",");
    }
}
