package com.ohgiraffers;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class A_EntityLifeCycleTests {

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
    public void 영속성_테스트_코드() {
        /* 새로운 Order 엔터티 추가 후 영속 상태로 만들기 */
        Order orderToRegist = new Order();

        orderToRegist.setOrderCode(98);
        orderToRegist.setOrderDate("20230619");
        orderToRegist.setOrderTime("16:13:13");
        orderToRegist.setTotalOrderPrice(50000);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try {
            entityManager.persist(orderToRegist);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();

            e.printStackTrace();
        }

        Assertions.assertTrue(entityManager.contains(orderToRegist));

        /* 준영속 상태로 만들기 */
        entityManager.detach(orderToRegist);

        orderToRegist.setTotalOrderPrice(30000);

        /* 준영속 상태이기 때문에 98번 코드의 토탈 값을 가져와도
        *  기존의 값을 가져오기 때문에 30000이 아니라 50000임
        *  assertEquals(30000, entityManager.find(Order.class, 98).getTotalOrderPrice());
        */
        assertEquals(50000, entityManager.find(Order.class, 98).getTotalOrderPrice());

        /* 다시 영속 상태로 만들기 */
        orderToRegist.setOrderCode(99);
        orderToRegist.setTotalOrderPrice(10000);

        entityManager.merge(orderToRegist);

        Order mergedOrder = entityManager.find(Order.class, 99);

        assertEquals(10000, mergedOrder.getTotalOrderPrice());

        /* 제거후 비영속 상태로 만들기 */
        entityManager.remove(mergedOrder);

        Order removeOrder = entityManager.find(Order.class, 99);

        assertEquals(null, removeOrder);
    }

}
