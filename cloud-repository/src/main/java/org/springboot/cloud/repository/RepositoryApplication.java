package org.springboot.cloud.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RepositoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class, args);
    }
}
