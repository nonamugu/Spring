package com.ohgiraffers.requestmappingandhandlermethodpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("userId")
public class OrderController {
    @PostMapping("confirm")
    public String confirmMenu(@ModelAttribute("order") OrderDTO order) {

        order.setDate(new Date(System.currentTimeMillis()));

        return "confirm";
    }
}