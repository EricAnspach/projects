package com.prs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrsJpaDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemo1Application.class, args);
		
		System.out.println("Hello Springboot world");
	}

}

