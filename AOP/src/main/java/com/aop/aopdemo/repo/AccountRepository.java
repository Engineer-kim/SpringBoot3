package com.aop.aopdemo.repo;

import com.aop.aopdemo.dto.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {
    private String name;
    private String serviceCode;


    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() +  ": Doing My DB Work");

    }

    public List<Account> findAccounts() {

        List<Account> accounts = new ArrayList<>();

        Account a = new Account("john" , "silver");
        Account b = new Account("john2" , "gold");

        accounts.add(a);
        accounts.add(b);

        return accounts;
    }

    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

}
