package com.ohgiraffers.exceptionhandlerpractice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public String userExceptionHandler(Model model,
                                       InvalidCredentialsException exception) {

        model.addAttribute("exception", exception);

        return "/error/401";
    }


}
