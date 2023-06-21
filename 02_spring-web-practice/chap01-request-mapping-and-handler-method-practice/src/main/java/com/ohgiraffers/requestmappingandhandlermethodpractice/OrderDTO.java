package com.ohgiraffers.requestmappingandhandlermethodpractice;

import java.util.Date;

public class OrderDTO {
    private String userId;
    private String orderCode;
    private int orderCount;
    private String orderName;
    private String Address;
    private String Phone;
    private Date Date;

    public OrderDTO() {
    }

    public OrderDTO(String userId, String orderCode, int orderCount, String orderName, String Address, String Phone, Date Date) {
        this.userId = userId;
        this.orderCode = orderCode;
        this.orderCount = orderCount;
        this.orderName = orderName;
        this.Address = Address;
        this.Phone = Phone;
        this.Date = Date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "nickName='" + userId + '\'' +
                ", orderItem='" + orderCode + '\'' +
                ", orderCnt=" + orderCount +
                ", orderName='" + orderName + '\'' +
                ", orderAddress='" + Address + '\'' +
                ", orderPhone='" + Phone + '\'' +
                ", orderDate=" + Date +
                '}';
    }
}