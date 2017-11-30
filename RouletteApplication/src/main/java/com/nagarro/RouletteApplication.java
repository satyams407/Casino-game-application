package com.nagarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class RouletteApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RouletteApplication.class, args);
		System.out.println("welcome to roulette");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RouletteApplication.class);
	}

}
