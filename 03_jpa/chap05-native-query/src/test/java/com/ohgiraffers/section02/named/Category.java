package com.ohgiraffers.section02.named;

import javax.persistence.*;

@Entity(name="category_section02")
@Table(name="tbl_category")

// 1-1의 매핑 이름과 다른 이름을 주어야 한다.
@SqlResultSetMapping(name = "categoryCountAutoMapping2",
        entities = {@EntityResult(entityClass = Category.class)},
        columns = {@ColumnResult(name = "menu_count")}
)
@NamedNativeQueries(
        value = {
                @NamedNativeQuery(
                        name = "Category.menuCountOfCategory",
                        query = "SELECT\n"
                                + " a.category_code, a.category_name, a.ref_category_code, \n"
                                + " COALESCE(v.menu_count, 0) menu_count\n"
                                + " FROM tbl_category a\n"
                                + " LEFT JOIN (SELECT COUNT(*) AS menu_count, b.category_code \n"
                                + " FROM tbl_menu b\n"
                                + " GROUP BY B.category_code) v "
                                + " ON (a.category_code = v.category_code)\n"
                                + " ORDER BY 1",
                        resultSetMapping = "categoryCountAutoMapping2"
                )
        }
)
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
