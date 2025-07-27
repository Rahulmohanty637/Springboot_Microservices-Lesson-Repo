package com.cipherwiz.demo.aot;

import org.aopalliance.intercept.Joinpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(* com.cipherwiz.demo.aot.service.JobService.getJob(..)) || execution(* com.cipherwiz.demo.aot.service.JobService.updateJob(..))")
    public void logMethodCall(Joinpoint jp){
        LOGGER.info("Method Called" /* + jp.getSignature().getName() */);
    }

    //    @After("execution(* com.cipherwiz.demo.aot.service.JobService.getJob(..)) || execution(* com.cipherwiz.demo.aot.service.JobService.updateJob(..))")
    public void logMethodExecuted(Joinpoint jp){
        LOGGER.info("Method Executed" /* + jp.getSignature().getName() */);
    }

    //    @AfterThrowing("execution(* com.cipherwiz.demo.aot.service.JobService.getJob(..)) || execution(* com.cipherwiz.demo.aot.service.JobService.updateJob(..))")
    public void logMethodCrash(Joinpoint jp){
        LOGGER.info("Method has some issues" /* + jp.getSignature().getName() */);
    }

    //    @AfterThrowing("execution(* com.cipherwiz.demo.aot.service.JobService.getJob(..)) || execution(* com.cipherwiz.demo.aot.service.JobService.updateJob(..))")
    public void logMethodSuccess(Joinpoint jp){
        LOGGER.info("Method Executed Successfully" /* + jp.getSignature().getName() */);
    }
}
