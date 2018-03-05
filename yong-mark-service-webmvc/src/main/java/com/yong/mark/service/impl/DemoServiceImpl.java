package com.yong.mark.service.impl;

import com.yong.mark.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @acthor yong.a.liang
 * @date 2018/03/01
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String getName(String id) {
        return id;
    }
}
