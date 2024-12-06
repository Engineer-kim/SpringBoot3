package com.aop.aopdemo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipRepository {

    public  boolean addSillyMember(){
        System.out.println(getClass() + ":  ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    public void suspendMembershipRepo() {

        System.out.println(getClass() + ": Suspend Membership Repo");

    }
}
