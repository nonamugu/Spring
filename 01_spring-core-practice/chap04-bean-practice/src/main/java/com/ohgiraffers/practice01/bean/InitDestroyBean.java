package com.ohgiraffers.practice01.bean;

import org.springframework.stereotype.Component;

@Component
public class InitDestroyBean {

    public void init() {
        System.out.println("init 작업이 실행되었습니다.");
    }

    public void destroy() {
        System.out.println("destroy 작업이 실행되었습니다.");
    }
}