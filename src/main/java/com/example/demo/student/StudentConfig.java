package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner studentCommandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "maraim",
                    "maraiam@gamil.com",
                    LocalDate.of(2000, Month.APRIL, 5)
            );
            Student alex = new Student(
                    "alex",
                    "alex@gamil.com",
                    LocalDate.of(2004, Month.APRIL, 5)
            );
            repository.saveAll(List.of(mariam, alex));


        };
    }

}
