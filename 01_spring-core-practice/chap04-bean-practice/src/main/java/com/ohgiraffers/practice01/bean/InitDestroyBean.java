package com.ohgiraffers.practice01.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class InitDestroyBean {

    @PostConstruct
    public void init() {
        System.out.println("init 작업이 실행되었습니다.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy 작업이 실행되었습니다.");
    }
}