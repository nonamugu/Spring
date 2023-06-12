package com.ohgiraffers.practice03.annotationconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beans = context.getBeanDefinitionNames();
        for(String bean : beans) {
            System.out.println(bean);
        }

        BoardDAO board = context.getBean(BoardDAO.class);

        System.out.println(board.selectBoard(1L));

        System.out.println(board.insertBoard(new BoardDTO(3L, "나는 상어", "뚜루룹뚜루~", "아기상어")));

        System.out.println(board.selectBoard(3L));

    }
}
