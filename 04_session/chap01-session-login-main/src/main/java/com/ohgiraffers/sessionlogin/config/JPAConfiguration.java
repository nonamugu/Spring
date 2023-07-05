package com.ohgiraffers.sessionlogin.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.ohgiraffers.sessionlogin")
@EnableJpaRepositories(basePackages = "com.ohgiraffers.sessionlogin")
public class JPAConfiguration {
}
