package com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRestApiReadTextfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiReadTextfileApplication.class, args);
	}

}
