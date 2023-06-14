package com.example.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    /* 요청 URL 설정 */
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        /* Model 객체에 addAttribute 메서드를 이용해
         * key, value를 추가하면 추후 view에서 사용할 수 있다. */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");

        /* 반환 하고자 하는 view의 경로를 포함한 이름을 작성한다.
         * resources/templates 하위부터의 경로를 작성한다. */
        return "mappingResult";
    }

    @RequestMapping(value="/menu/modify", method= RequestMethod.GET)
    public String modifyMenu(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 수정용 메소드 호출함...");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 삭제용 메소드 호출함...");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {

        model.addAttribute("message", "POST 방식의 메뉴 삭제용 메소드 호출함...");

        return "mappingResult";
    }




}
