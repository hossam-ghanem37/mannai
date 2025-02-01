package com.mannai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mannai", "com.mannai.config"})

public class MannaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MannaiApplication.class, args);
	}

}
