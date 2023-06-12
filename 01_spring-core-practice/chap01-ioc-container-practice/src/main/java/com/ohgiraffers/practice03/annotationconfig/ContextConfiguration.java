package com.ohgiraffers.practice03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("practice03Configuration")
@ComponentScan(basePackages="com.ohgiraffers.practice03.annotationconfig")
public class ContextConfiguration {

}
