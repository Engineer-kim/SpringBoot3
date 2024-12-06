package com.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.aop.aopdemo.repo.*.*(..))")
    public void forRepoPackage() {}

    @Pointcut("execution(* com.aop.aopdemo.repo.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.aop.aopdemo.repo.*.set*(..))")
    public void setter() {}

    @Pointcut("forRepoPackage() && !(getter() || setter())")
    public void forRepoPackageNoGetterSetter() {}
}