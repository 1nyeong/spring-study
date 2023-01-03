package com.study.springboot202210h.aop;

import com.study.springboot202210h.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210junil.web.controller.account.AccountApiController.*(..))")
    private void executionPointCut() {}

    @Pointcut("@annotation(com.study.springboot202210junil.aop.annotation.ValidAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg);
        }

        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult != null) {
            if(bindingResult.hasErrors()) {
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }

        // 메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed();
        // 메소드 호출 후 처리

        return returnValue;
    }
}
