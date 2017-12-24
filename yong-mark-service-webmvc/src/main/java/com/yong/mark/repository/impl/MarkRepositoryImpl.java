package com.yong.mark.repository.impl;

import com.yong.mark.repository.MarkRepositoryCustom;
import com.yong.model.Mark;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LiangYong
 * @date 2017/11/23
 */
@AllArgsConstructor
@Repository
public class MarkRepositoryImpl implements MarkRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Mark> findAllActivityItems() {
        return  mongoTemplate.findAll(Mark.class);
    }
}
