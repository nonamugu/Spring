package com.ohgiraffers.springdatajpa.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;

@Entity
@Table(name="tbl_category")
public class Category {
    @Id
    @Column(name="category_code")
    private int categoryCode;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="ref_category_code")
    private Integer refCategoryCode;
    public Category() {}
    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        super();
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }
    public int getCategoryCode() {
        return categoryCode;
    }
    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }
    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }
    @Override
    public String toString() {
        return "Category [categoryCode=" + categoryCode + ", categoryName=" + categoryName
                + ", refCategoryCode=" + refCategoryCode + "]";
    }
}
