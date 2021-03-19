package com.springbasics.web.springboot.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectClass {
    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Before("com.springbasics.web.springboot.Aspects.PointCuts.businessPointCut()")
    public void checkBeforeMethod(JoinPoint joinPoint) {
        LOG.info("This is a business service call {}", joinPoint);
    }

    @AfterReturning(value = "com.springbasics.web.springboot.Aspects.PointCuts.businessPointCut()", returning = "result")
    private void checkAfterMethod(JoinPoint joinPoint, Object result) {
        LOG.info("Method {} returned {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.springbasics.web.springboot.Aspects.PointCuts.businessPointCut()", throwing = "exception")
    private void checkForException(JoinPoint joinPoint, Exception exception) {
        LOG.info("Method {} throw exception {}", joinPoint, exception);
    }

    @Around(value = "com.springbasics.web.springboot.Aspects.PointCuts.trackTimePointCut()")
    private void trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        LOG.info("Method {} ran {} milliseconds", proceedingJoinPoint, executionTime);
    }


}
