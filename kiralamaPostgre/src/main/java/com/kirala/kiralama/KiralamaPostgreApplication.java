package com.kirala.kiralama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@ComponentScan("com.kirala.kiralama")
@SpringBootApplication
public class KiralamaPostgreApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(KiralamaPostgreApplication.class, args);
    }
}
