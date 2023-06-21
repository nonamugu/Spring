package com.ohgiraffers.practice01.bean;

public class SingletonBean {

    private String message;

    public SingletonBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}