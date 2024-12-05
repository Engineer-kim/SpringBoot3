package com.aop.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

    @Before("execution(void com.aop.aopdemo.repo.AccountRepository.addAccount())")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n===========================> Execute @Before Adivce On addAccount");
    }
}
