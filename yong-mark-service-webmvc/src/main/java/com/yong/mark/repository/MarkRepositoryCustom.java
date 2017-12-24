package com.yong.mark.repository;

import com.yong.model.Mark;

import java.util.List;

/**
 * @author LiangYong
 * @date 2017/11/23
 */
public interface MarkRepositoryCustom {

    List<Mark> findAllActivityItems();
}
