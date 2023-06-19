package com.ohgiraffers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;

@Entity(name="order")
@Table(name="tbl_order")
public class Order {
    @Id
    @Column(name="order_code")
    private int orderCode;
    @Column(name="order_date")
    private String orderDate;
    @Column(name="order_time")
    private String orderTime;
    @Column(name="total_order_price")
    private int totalOrderPrice;

    public Order() { }

    public Order(int orderCode, String orderDate, String orderTime, int totalOrderPrice) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.totalOrderPrice = totalOrderPrice;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int orderPrice) {
        this.totalOrderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", orderPrice=" + totalOrderPrice +
                '}';
    }
}
