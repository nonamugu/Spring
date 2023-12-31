package com.ohgiraffers.section05.groupfunction;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroupFunctionTests {
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
    public void 특정_카테고리의_등록된_메뉴_수_조회() {
        // given
        int categoryCodeParameter = 4;

        // when
        String jpql = "SELECT COUNT(m.menuPrice) FROM menu_section05 m "
                + "WHERE m.categoryCode = :categoryCode";
        long countOfMenu = entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCodeParameter)
                .getSingleResult();

        // then
        assertTrue(countOfMenu >= 0);

        System.out.println(countOfMenu);
    }

    @Test
    public void count를_제외한_다른_그룹함수의_조회결과가_없는_경우_테스트() {
        // given
        int categoryCodeParameter = 2;

        // when
        String jpql = "SELECT SUM(m.menuPrice) FROM menu_section05 m WHERE m.categoryCode = :categoryCode";

        // then
        assertThrows(NullPointerException.class, () -> {
            /* 반환 값을 담을 변수의 타입을 기본 자료형으로 하는 경우 Wrapper 타입을 언박싱 하는 과정에서 NPE이 발생하게 된다. */
            long sumOfPrice = entityManager.createQuery(jpql, Long.class)
                    .setParameter("categoryCode", categoryCodeParameter)
                    .getSingleResult();
        });

        assertDoesNotThrow(() -> {
            /* 반환 값을 담는 변수를 Wrapper 타입으로 선언해야 null 값이 반환 되어도 NPE가 발생하지 않는다. */
            Long sumOfPrice = entityManager.createQuery(jpql, Long.class)
                    .setParameter("categoryCode", categoryCodeParameter)
                    .getSingleResult();
        });
    }

    @Test
    public void groupby절과_having절을_사용한_조회_테스트() {
        // given
        long minPrice = 50000L;         // 그룹함수의 반환 타입은 Long이므로 비교를 위한 파라미터도 Long 타입을 사용해야 한다.

        // when
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice)"
                + " FROM menu_section05 m"
                + " GROUP BY m.categoryCode"
                + " HAVING SUM(m.menuPrice) >= :minPrice";
        List<Object[]> sumPriceOfCategoryList = entityManager.createQuery(jpql, Object[].class)
                .setParameter("minPrice", minPrice)
                .getResultList();

        // then
        assertNotNull(sumPriceOfCategoryList);

        sumPriceOfCategoryList.forEach(row -> {
            Arrays.stream(row).forEach(System.out::println);
        });
    }


}
