package com.ohgiraffers.practice03.setter;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    private MemberDAO memberDAO;

    @Autowired
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> selectMember() {
        return memberDAO.selectMember();
    }

}