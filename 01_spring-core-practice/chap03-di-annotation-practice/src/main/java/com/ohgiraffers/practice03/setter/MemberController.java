package com.ohgiraffers.practice03.setter;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller("memberControllerSetter")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public Map<Long, MemberDTO> selectMember() {
        return memberService.selectMember();
    }
}