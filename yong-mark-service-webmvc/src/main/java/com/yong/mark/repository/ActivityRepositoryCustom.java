package com.yong.mark.repository;

import com.yong.model.Activity;
import com.yong.model.ActivitySummaryVo;

import java.util.List;

public interface ActivityRepositoryCustom {
    List<ActivitySummaryVo> getActivitySummary();
}
