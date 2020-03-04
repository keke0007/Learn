package com.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@Slf4j
public class TimeAspect {
    @Around("execution(* com.demo.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {

    /*    System.out.println("time aspect start");

        Object[] args = pjp.getArgs();

        for (Object arg : args) {
            System.out.println("arg is "+arg);
        }

        long start = new Date().getTime();

        //Object目标方法的返回值
        Object object = pjp.proceed();

        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));

        System.out.println("time aspect end");

        return object;*/
        Object result = null;
        System.out.println("time aspect start");
        long start = new Date().getTime();
        try {
            //获得类名
            String clazzName = joinPoint.getTarget().getClass().getSimpleName();
            //获得方法名
            String methodName = joinPoint.getSignature().getName();
            //获得参数列表
            Object[] args = joinPoint.getArgs();
            log.info("clazzName:{},methodName:{},args:{}",clazzName,methodName,args.length > 0 ? args[0] : null);
            //执行切点,就是* com.mlsama.springbootoracle.service..*.*(..)表达式匹配的方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("发生异常:{}",e);
            //此处可以插入异常日志
            //处理异常
//            ExceptionHandler.handle(e);
        }
        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));

        System.out.println("time aspect end");
        return result;

    }
}
