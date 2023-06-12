package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("Practice02Configuration")
public class ContextConfiguration {

    @Bean(name="board")
    public BoardDTO getBoard() {

        return new BoardDTO(1234L, "나는문어", "꿈을꾸는문어", "김재현");
    }
}
