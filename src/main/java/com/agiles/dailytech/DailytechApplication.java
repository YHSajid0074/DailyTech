package com.agiles.dailytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DailytechApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailytechApplication.class, args);
	}

}
