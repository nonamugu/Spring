package com.ohgiraffers.interceptorpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoggerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if(request.getRequestURI().equals("/books")) {
            log.info("[preHandle][GET]/books");
        } else if (request.getRequestURI().equals("/books/1")) {
            log.info("[preHandle][GET]/books/1");
        }

        /* true이면 컨트롤러를 이어서 호출한다. false이면 핸들러 메소드를 호출하지 않는다. */
        return true;
    }

}