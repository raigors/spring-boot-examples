package com.github.spring.boot.mongodb.repository.impl;

import com.github.spring.boot.mongodb.pojo.UserResumeDO;
import com.github.spring.boot.mongodb.pojo.UserResumeQueryDTO;
import com.github.spring.boot.mongodb.pojo.UserResumeResultDTO;
import com.github.spring.boot.mongodb.repository.IUserResumeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/28 4:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Repository
public class UserResumeRepositoryImpl implements IUserResumeRepository<UserResumeResultDTO, UserResumeQueryDTO> {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserResumeResultDTO> findAllByQueryConditions(UserResumeQueryDTO query) {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("createdDate").gte(query.getStartDate()).lt(query.getEndDate())),
                Aggregation.project("username", "age"),
                Aggregation.group("username")
                        .first("username").as("username")
                        .sum("age").as("sum"),
                Aggregation.sort(Sort.Direction.DESC, "sum"),
                Aggregation.limit(5)
        );
        AggregationResults<UserResumeResultDTO> result = mongoTemplate.aggregate(agg, UserResumeDO.class, UserResumeResultDTO.class);
        return result.getMappedResults();
    }
}

