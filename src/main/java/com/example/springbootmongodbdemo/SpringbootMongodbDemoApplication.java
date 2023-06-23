package com.example.springbootmongodbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringbootMongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbDemoApplication.class, args);
    }

}
