package com.pr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class EmpMngSystemSpringbootApplication {

	public static void main(String[] args) {
		System.out.println("*** Welcome to EmpMngSystemSpringbootApplication***");
		SpringApplication.run(EmpMngSystemSpringbootApplication.class, args);
	}

}
