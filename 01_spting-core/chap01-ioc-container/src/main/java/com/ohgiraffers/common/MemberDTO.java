package com.ohgiraffers.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDTO {

    private int sequence;   // 회원번호
    private String id;      // 아이디
    private String pwd;     // 비밀번호
    private String name;    // 이름

}