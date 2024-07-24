package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.keyin")
public class RESTServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RESTServiceApplication.class, args);
    }
}
