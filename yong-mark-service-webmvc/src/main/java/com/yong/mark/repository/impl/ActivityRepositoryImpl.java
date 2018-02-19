package com.yong.mark.repository.impl;

import com.yong.mark.model.HotPlayerPatron;
import com.yong.mark.repository.ActivityRepositoryCustom;
import com.yong.model.Activity;
import com.yong.model.ActivitySummaryVo;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
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
    public List<Activity> getActivitySummary() {
//        Aggregation aggregation = newAggregation(
//            project()
//            .and("_id").as("id")
//        );
//        List<Activity> result = operations.aggregate(aggregation,"activity",Activity.class).getMappedResults();
//        return result;
        return null;
    }
}
