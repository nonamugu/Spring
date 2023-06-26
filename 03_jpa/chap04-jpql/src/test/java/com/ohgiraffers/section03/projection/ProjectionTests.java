package com.ohgiraffers.section03.projection;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProjectionTests {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }
    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }
    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }
    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 단일_엔티티_프로젝션_테스트() {
        // when
        String jpql = "SELECT m FROM menu_section03 m";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        // then
        assertNotNull(menuList);

        /* 엔티티 프로젝션은 영속성 컨텍스트에서 관리하는 객체가 된다. */
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        menuList.get(1).setMenuName("test2");
        entityTransaction.commit();
    }

    @Test
    public void 임베디드_타입_프로젝션_테스트() {
        // when
        String jpql = "SELECT m.menuInfo FROM embedded_menu m";
        List<MenuInfo> menuInfoList = entityManager.createQuery(jpql, MenuInfo.class).getResultList();

        // then
        assertNotNull(menuInfoList);

        menuInfoList.forEach(System.out::println);
    }

    @Test
    public void TypedQuery를_이용한_스칼라_타입_프로젝션_테스트() {
        // when
        String jpql = "SELECT c.categoryName FROM category_section03 c";
        List<String> categoryNameList = entityManager.createQuery(jpql, String.class).getResultList();

        // then
        assertNotNull(categoryNameList);

        categoryNameList.forEach(System.out::println);
    }

    @Test
    public void Query를_이용한_스칼라_타입_프로젝션_테스트() {
        // when
        String jpql = "SELECT c.categoryCode, c.categoryName FROM category_section03 c";
        List<Object[]> categoryList = entityManager.createQuery(jpql).getResultList();

        // then
        assertNotNull(categoryList);

        categoryList.forEach(row -> {
            Arrays.stream(row).forEach(System.out::println);
        });
    }

    @Test
    public void new_명령어를_활용한_프로젝션_테스트() {
        // when
        String jpql = "SELECT new com.ohgiraffers.section03.projection.CategoryInfo"
                + "(c.categoryCode, c.categoryName) FROM category_section03 c";
        List<CategoryInfo> categoryInfoList = entityManager.createQuery(jpql, CategoryInfo.class)
                .getResultList();

        // then
        assertNotNull(categoryInfoList);

        categoryInfoList.forEach(System.out::println);
    }


}
