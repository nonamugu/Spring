package com.ohgiraffers.interceptorpractice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping("")
    public String list(Model model) {
        // 기능 수행 코드 생략

        return "book/list";
    }

    @GetMapping("/{bookCode}")
    public String detail(@PathVariable String bookCode, Model model) {
        // 기능 수행 코드 생략

        return "book/detail";
    }
}