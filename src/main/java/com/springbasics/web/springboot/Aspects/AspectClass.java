package com.springbasics.web.springboot.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
}
