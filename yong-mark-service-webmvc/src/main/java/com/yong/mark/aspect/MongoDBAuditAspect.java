package com.yong.mark.aspect;

import com.yong.mark.service.impl.SequenceServiceImpl;
import com.yong.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
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
        t.setCreatedDate(new Date());
        //TODO implement setAuditFields
        t.setCreatedBy("anonymous");
        setId(t);
        log.debug("start insert Entity, entity = {}", t);
    }

    @Before("execution(* com.yong.mark.repository.*.save(..)) && args(t)")
    public void updateAudit(T t) {
        //TODO implement setAuditFields
        t.setLastModifiedBy("anonymous");
        t.setLastModifiedDate(new Date());
        setId(t);
        log.debug("start update Entitiy, entity = {}", t);
    }

    public void setId(T t) {
        if (t.getId() == null) {
            log.debug("class name = {}", t.getClass().getName());
            t.setId(sequenceService.getNextSequence(t.getClass().getName()));
        }
    }


//    @Pointcut("execution(* org.springframework.data.mongodb.repository.MongoRepository.insert(..)) && args(object)")
//    public void testSendKafkaMesage(T object) {
//    }
//
//    @AfterReturning("testSendKafkaMesage(t)")
//    public void selectEventSource(T t) {
//        log.info("this is AfterReturning method! T = {}", t);
//    }

//    @Before("execution(* com.yong.mark.repository.*.insert(..)) && args(t)")
//    public void before(T t){
//        log.info("this is before method! T = {}",t);
//    }
//
//    @After("execution(* com.yong.mark.repository.*.insert(..)) && args(t)")
//    public void afterTest(T t){
//        log.info("this is After method! T = {}",t);
//    }

}

