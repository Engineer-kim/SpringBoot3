package com.aop.aopdemo.aspect;


import com.aop.aopdemo.dto.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {

    @AfterThrowing(
            pointcut = "execution(* com.aop.aopdemo.repo.AccountRepository.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>> The exception is: " + theExc);
    }


    @AfterReturning(pointcut = "execution(*  com.aop.aopdemo.repo.AccountRepository(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint , List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
        System.out.println("\n=====>>> result is: " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====>>> result is: " + result);

    }
    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String theUpperName = account.getName().toUpperCase();
            account.setName(theUpperName);
        }
    }


    @Before("com.aop.aopdemo.aspect.AopExpressions.forRepoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }



}
