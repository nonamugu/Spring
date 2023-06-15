package com.ohgiraffers.common;

import lombok.Data;

@Data
public class BoardDTO {

    private Long id;
    private String title;
    private String content;
    private MemberDTO writer;

}