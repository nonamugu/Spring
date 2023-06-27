package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value="SELECT category_code, category_name, ref_category_code " +
            "FROM tbl_category ORDER BY category_code ASC", nativeQuery = true)
    public List<Category> findAllCategory();
}
