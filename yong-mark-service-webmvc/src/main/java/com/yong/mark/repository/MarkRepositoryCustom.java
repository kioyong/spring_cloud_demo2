package com.yong.mark.repository;

import com.yong.mark.model.HotPlayerPatron;
import com.yong.mark.model.PatronValue;
import com.yong.model.Mark;

import java.util.List;

/**
 * @author LiangYong
 * @date 2017/11/23
 */
public interface MarkRepositoryCustom {

    List<Mark> findAllActivityItems();
    List<HotPlayerPatron> findAggregateByCustom();
    List<PatronValue> findAggregateBuyReduce();
}
