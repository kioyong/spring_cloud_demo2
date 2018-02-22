package com.yong.mark.repository.impl;

import com.yong.mark.model.HotPlayerPatron;
import com.yong.mark.repository.ActivityRepositoryCustom;
import com.yong.model.Activity;
import com.yong.model.ActivitySummaryVo;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author LiangYong
 * @date 2018/02/19
 */
@Repository
@AllArgsConstructor
public class ActivityRepositoryImpl implements ActivityRepositoryCustom {

    private final MongoOperations operations;

    @Override
    public List<ActivitySummaryVo> getActivitySummary() {
        Aggregation aggregation = newAggregation(
            project()
            .and("_id").as("id")
            .andExpression("reduce(activitySessions,0,add($$value,sum($$this.fills.value)))").as("fill")
            .andExpression("reduce(activitySessions,0,add($$value,sum($$this.credits.value)))").as("credit")
            .andExpression("sum(activitySessions.value)").as("opener")
        );
        List<ActivitySummaryVo> result = operations.aggregate(aggregation,"activity",ActivitySummaryVo.class).getMappedResults();
        return result;
    }
}