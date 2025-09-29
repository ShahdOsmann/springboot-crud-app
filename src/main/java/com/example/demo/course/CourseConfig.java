package com.example.demo.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean
    CommandLineRunner courseCommandLineRunner(CourseRepository repository) {
        return args -> {
            Course javaCourse = new Course(
                    "Introduction to Java Programming",
                    "Dr. Mostafa",
                    "Computer Science"
            );
            Course webDevCourse = new Course(
                    "Web Development Fundamentals",
                    "Prof. Saad",
                    "Information Technology"
            );
            repository.saveAll(List.of(javaCourse, webDevCourse));


        };
    }

}
