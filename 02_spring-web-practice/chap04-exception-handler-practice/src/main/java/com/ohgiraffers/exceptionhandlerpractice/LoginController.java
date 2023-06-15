package com.ohgiraffers.exceptionhandlerpractice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @PostMapping("/main")
    public String LoginRedirect(HttpServletRequest request) throws InvalidCredentialsException {
        String username = request.getParameter("userId");
        String password = request.getParameter("userPass");

        if (!(username.equals("user01") && password.equals("pass01"))) {
            // 불일치 할 경우 InvalidCredentialsException 발생
            throw new InvalidCredentialsException("유효한 자격 증명 없음");
        }

        // 일치할 경우 main으로 redirect
        return "redirect:/main";
    }


}
