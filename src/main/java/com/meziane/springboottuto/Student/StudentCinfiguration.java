package com.meziane.springboottuto.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentCinfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           Student meziane= new Student("Meziane",
                    "meziane@gmail.com",
                    LocalDate.of(1995,9,17));

            Student haitham= new Student("Haitham",
                    "haitham@gmail.com",
                    LocalDate.of(1995,9,17));
            Student leila= new Student("Leila",
                    "leila@gmail.com",
                    LocalDate.of(1995,9,17));
            Student fouad= new Student("Fouad",
                    "fouad=@gmail.com",
                    LocalDate.of(1995,9,17));

            studentRepository.saveAll(List.of(meziane,haitham,fouad,leila));

        };
    }
}
