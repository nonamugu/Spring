package com.ohgiraffers.requestmappingandhandlermethodpractice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("userId")
public class MainController {
    @PostMapping("main")
    public String sessionTest1(Model model, @RequestParam String userId) {

        model.addAttribute("userId", userId);

        return "main";
    }
}