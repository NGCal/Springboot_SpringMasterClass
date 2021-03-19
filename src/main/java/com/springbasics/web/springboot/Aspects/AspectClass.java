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

    @Before("execution(* com.springbasics.web.springboot.Bussines.*.*(..))")
    public void checkBeforeMethod(JoinPoint joinPoint) {
        LOG.info("This is a business service call {}", joinPoint);
    }

    @AfterReturning(value = "execution(* com.springbasics.web.springboot.Bussines.*.*(..))", returning = "result")
    private void checkAfterMethod(JoinPoint joinPoint, Object result) {
        LOG.info("Method {} returned {}", joinPoint, result);
    }

    @AfterThrowing(value = "execution(* com.springbasics.web.springboot.Bussines.*.*(..))", throwing = "exception")
    private void checkForException(JoinPoint joinPoint, Exception exception) {
        LOG.info("Method {} throw exception {}", joinPoint, exception);
    }

    @Around(value = "execution(* com.springbasics.web.springboot.Bussines.*.*(..))")
    private void trackTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        LOG.info("Method {} ran {} milliseconds", proceedingJoinPoint, executionTime);
    }


}
