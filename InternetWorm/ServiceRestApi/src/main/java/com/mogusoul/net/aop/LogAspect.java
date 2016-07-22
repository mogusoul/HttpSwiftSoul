package com.mogusoul.net.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/22.
 */

@Aspect
@Component
public class LogAspect {


    @Pointcut("@annotation(com.mogusoul.net.aop.Action)")
    public void pointCut(){

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);

        System.out.println("AOP 注解式拦截: "+action.name());
    }

//    @Before("execution(*com.mogusoul.net.aspect.MethodAspect.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);

        System.out.println("AOP 方法规则式拦截: "+method.getName());
    }



}
