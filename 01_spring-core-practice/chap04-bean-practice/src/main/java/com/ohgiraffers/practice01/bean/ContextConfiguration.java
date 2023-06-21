package com.ohgiraffers.practice01.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.ohgiraffers.practice01.bean")
public class ContextConfiguration {

    public static Long SINGLETON_COUNT = 1L;
    public static Long PROTOTYPE_COUNT = 1L;

    /* 위의 상수를 활용하여 빈 등록 코드 작성 */
    @Bean
    @Scope("singleton")
    public SingletonBean singletonBean() {
        return new SingletonBean(SINGLETON_COUNT++ + "번째 메세지");
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean() {
        return new PrototypeBean(PROTOTYPE_COUNT++ + "번째 메세지");
    }

}