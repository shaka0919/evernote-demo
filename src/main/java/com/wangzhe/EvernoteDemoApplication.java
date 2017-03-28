package com.wangzhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Controller"})
public class EvernoteDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvernoteDemoApplication.class, args);
	}
}
