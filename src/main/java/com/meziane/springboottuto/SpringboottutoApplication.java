package com.meziane.springboottuto;

import com.meziane.springboottuto.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication

public class SpringboottutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottutoApplication.class, args);
	}


}
