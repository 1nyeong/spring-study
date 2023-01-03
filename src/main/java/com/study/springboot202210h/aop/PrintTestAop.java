package com.study.springboot202210h.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintTestAop {

    @Pointcut("@annotation(com.study.springboot202210junil.aop.annotation.PrintTestAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("PrintTestAop 전처리 실행!!");
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println("매개변수 데이터 >>> " + arg);
        }

        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("메소드 결과 >>> " + returnValue);
        System.out.println("PrintTestAop 후처리 실행");

        return returnValue;
    }

}