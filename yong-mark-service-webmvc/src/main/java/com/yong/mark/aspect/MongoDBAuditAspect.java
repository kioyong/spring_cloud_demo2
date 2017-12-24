package com.yong.mark.aspect;

import com.yong.mark.service.impl.SequenceServiceImpl;
import com.yong.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class MongoDBAuditAspect<T extends BaseEntity> {

    private final SequenceServiceImpl sequenceService;

    //testdemo
//    @Before("execution(* com.yong.mark.repository.*.findById(..))")
//    public void test() {
//        log.debug("start findById~~~~");
//    }

    @Before("execution(* com.yong.mark.repository.*.insert(..)) && args(t)")
    public void insertAudit(T t) {
        log.debug("start insert Entity, entity = {}", t);
        t.setCreatedDate(new Date());
        //TODO implement setAuditFields
        t.setCreatedBy("anonymous");

        String id = t.getId();
        if(id == null){
            log.debug("class name = {}",t.getClass().getName());
            int nextSequence = sequenceService.getNextSequence(t.getClass().getName());
            t.setId(String.valueOf(nextSequence));
        }
    }

    @Before("execution(* com.yong.mark.repository.*.save(..)) && args(t)")
    public void updateAudit(T t){
        log.debug("start update Entitiy, entity = {}", t);
        //TODO implement setAuditFields
        t.setLastModifiedBy("anonymous");
        t.setLastModifiedDate(new Date());

    }

}

