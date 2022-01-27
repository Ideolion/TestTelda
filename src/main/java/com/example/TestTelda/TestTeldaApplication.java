package com.example.TestTelda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestTeldaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTeldaApplication.class, args);
		
	}

}
