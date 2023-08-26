package com.mohammadtest.mongoCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class MongoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoCrudApplication.class, args);
	}

}
