package com.practice.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.model.Student;
import com.practice.repository.StudentRepository;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository) {
        return args -> {
            Student s1 = new Student(
                "S",
				"s@gmail.com",
				LocalDate.of(2015, Month.JANUARY, 1)
			);
            Student s2 = new Student(
                "V",
				"v@gmail.com",
				LocalDate.of(2000, Month.JANUARY, 21)
			);

            studentRepository.saveAll(
                List.of(s1, s2)
            );
        };
    }
    
}
