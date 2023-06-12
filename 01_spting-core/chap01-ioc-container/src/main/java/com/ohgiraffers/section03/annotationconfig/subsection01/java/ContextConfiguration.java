package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration("section03ContextConfiguration")
@ComponentScan(basePackages="com.ohgiraffers",
        useDefaultFilters=false,
        includeFilters= {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { MemberDAO.class })
        })

public class ContextConfiguration {

}
