package com.aop.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TestService {

    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5); //5초 동안 쓰레드 정지
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "getFortune 끝남요";
    }
}
