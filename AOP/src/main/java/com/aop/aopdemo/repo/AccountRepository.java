package com.aop.aopdemo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    public  void addAccount(){
        System.out.println(getClass() +  ": Doing My DB Work");

    }

}
