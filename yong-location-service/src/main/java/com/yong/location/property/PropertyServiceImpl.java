package com.yong.location.property;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService {

    @Override
    @Async
    public String getFirstProperty() {
        try {
            log.debug("start get first property");
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FirstProperty";
    }

    @Override
    @Async
    public String getSecondProperty() {
        try {
            log.debug("start get second property");
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SecondProperty";
    }
}
