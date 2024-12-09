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
        return findAccounts(false);
    }

    public List<Account> findAccounts(boolean booleanValue) {
        if (booleanValue) { //넘겨받은 booleanValue 이게 True 면 오류 false 면 굿
            throw new RuntimeException("런타임 오류요");
        }

        List<Account> myAccounts = new ArrayList<>();
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
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
