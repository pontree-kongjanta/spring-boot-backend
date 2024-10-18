package com.example.training.myApp4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MyApp4Application {

	public static void main(String[] args) {
		SpringApplication.run(MyApp4Application.class, args);
	}

}
