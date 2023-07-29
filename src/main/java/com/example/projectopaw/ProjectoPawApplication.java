package com.example.projectopaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.projectopaw.repositories")
public class ProjectoPawApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectoPawApplication.class, args);
    }

}
