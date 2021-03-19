package com.springbasics.web.springboot.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {
    @Pointcut("execution(* com.springbasics.web.springboot.Bussines.*.*(..))")
    public void businessPointCut() {
    }

    @Pointcut("execution(* com.springbasics.web.springboot.Data.*.*(..))")
    public void dataPointCut() {
    }
}
