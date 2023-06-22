package com.ohgiraffers.section03.bidirection;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiDirectionAssociationTests {

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
    public void 양방향_연관관계_매핑_조회_테스트() {
        // given
        int menuCode = 10;
        int categoryCode = 10;

        // when
        /* 진짜 연관 관계는 처음 조회 시부터 조인한 결과를 인출해온다. */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        /* 가짜 연관 관계는 해당 엔티티를 조회하고 필요 시 연관 관계 엔티티를 조회하는 쿼리를 다시 실행하게 된다. */
        Category foundCategory = entityManager.find(Category.class, categoryCode);

        // then
        assertEquals(menuCode, foundMenu.getMenuCode());
        assertEquals(categoryCode, foundCategory.getCategoryCode());

        /* 주의사항!
         * toString() 오버라이딩 시 양방향 연관 관계는 재귀호출이 일어나기 때문에 stackOverFlowError가 발생하게 된다.
         * 따라서 재귀가 일어나지 않게 하기 위해서는 엔티티의 주인이 아닌 쪽의
         * toString을 연관 객체 부분이 출력 되지 않도록 해야 한다.
         * 특히 자동 완성 및 롬복 라이브러리를 이용하는 경우 해당 문제 발생 가능성이 매우 높아진다.
         * */
        System.out.println(foundMenu);
        System.out.println(foundCategory);

        /* category에 포함 된 메뉴 목록 출력 구문을 작성하고 나면 실제 사용에 필요해지기 때문에 가짜 연관 관계에 해당하는 엔티티도
         * 다시 조회하는 쿼리가 한 번 더 동작한다. */
        foundCategory.getMenuList().forEach(System.out::println);
    }

    @Test
    public void 양방향_연관관계_주인_객체를_이용한_삽입_테스트() {
        // given
        Menu menu = new Menu();

        menu.setMenuCode(125);
        menu.setMenuName("연관관계주인메뉴");
        menu.setMenuPrice(10000);
        menu.setOrderableStatus("Y");
//        menu.setCategory(entityManager.find(Category.class, 4));

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(menu);

        entityTransaction.commit();

        // then
        Menu foundMenu = entityManager.find(Menu.class, menu.getMenuCode());
        assertEquals(menu.getMenuCode(), foundMenu.getMenuCode());
        System.out.println(foundMenu);
    }

    @Test
    public void 양방향_연관관계_주인이_아닌_객체를_이용한_삽입_테스트() {
        // given
        Category category = new Category();

        category.setCategoryCode(1004);
        category.setCategoryName("양방향카테고리");
        category.setRefCategoryCode(null);

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(category);

        entityTransaction.commit();

        // then
        Category foundCategory = entityManager.find(Category.class, category.getCategoryCode());

        assertEquals(category.getCategoryCode(), foundCategory.getCategoryCode());

        System.out.println(foundCategory);
    }
}
