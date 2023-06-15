package com.ohgiraffers.practice02.constructor;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller("memberControllerConstructor")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public Map<Long, MemberDTO> selectMember() {
        return memberService.selectMember();
    }

}