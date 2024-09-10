package com.siit.class22project;

import com.siit.class22project.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Class22projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Class22projectApplication.class, args);
	}


	@Bean
	public AppConfig appConfig() {
		return new AppConfig("ro", "ron");
	}


}
