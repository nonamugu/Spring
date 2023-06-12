package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDTO {

    private Long id;                        //아이디
    private String title;                   //제목
    private String content;                 //내용
    private String writer;                  //작성자

}
