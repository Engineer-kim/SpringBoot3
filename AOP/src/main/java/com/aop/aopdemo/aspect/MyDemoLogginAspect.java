package com.aop.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {


    @Before("com.aop.aopdemo.aspect.AopExpressions.forRepoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

}
