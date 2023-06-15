package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public MemberDTO getMember() {
        MemberDTO member = new MemberDTO();
        member.setId(1L);
        member.setNickname("봄이올까요");

        return member;
    }
    @Bean
    public BoardDTO getBoard() {
        /* MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
        BoardDTO board = new BoardDTO();
        board.setId(1L);
        board.setTitle("의존성 주입 연습");
        board.setContent("게시글의 작성자 객체를 주입 받아볼게요!");
        /* setter를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
        board.setWriter(getMember());

        return board;
    }

}
