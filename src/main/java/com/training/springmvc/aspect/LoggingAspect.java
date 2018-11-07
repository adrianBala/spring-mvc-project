package com.training.springmvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.training.springmvc.controller.*.*(..))")
    private void forControllerPackage() { }

    @Pointcut("execution(* com.training.springmvc.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.training.springmvc.dao.*.*(..))")
    private void forDaoPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() { }

    @Before("forAppFlow()")
    public void before(JoinPoint theJointPoint) {
        String method = theJointPoint.getSignature().toShortString();
        myLogger.info("====> in @Before: calling method: " + method);
        Object [] args = theJointPoint.getArgs();
        for(Object tempArg : args) {
            myLogger.info("====> Argument: " + tempArg);
        }
    }

    @AfterReturning(pointcut ="forAppFlow()", returning="result")
    public void afterReturning(JoinPoint theJointPoint, Object result) {
        String method = theJointPoint.getSignature().toShortString();
        myLogger.info("====> @AfterReturning: from method: " + method);
        myLogger.info(("====> result: " + result));
    }
}
