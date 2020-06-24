package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class TestAspect {
//    @Pointcut("(execution(* com.example.demo..*.*(..)))")
//    public void pointCut() {
//    }
    @Pointcut("@annotation(com.example.demo.annotation.MyAnnotation)")
    public void pointCut() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        System.out.println("start aspect");
    }

}
