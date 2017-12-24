package com.yong.service.repository;

import com.yong.model.Mark;
import reactor.core.publisher.Flux;

/**
 * @author LiangYong
 * @date 2017/11/23
 */
public interface MarkRepositoryCustom {

    Flux<Mark> findAllActivityItems();
}
