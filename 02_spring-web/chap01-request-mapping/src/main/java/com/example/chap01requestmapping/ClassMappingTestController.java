package com.example.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "GET방식의 주문 등록용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {
        model.addAttribute("message", "POST 방식의 주문 수정/삭제용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) {
        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @RequestMapping
    public String otherRequst(Model model) {
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비되지 않음...");

        return "mappingResult";
    }


}
