package ru.job4j.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevOpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevOpsApplication.class, args);
		System.out.println("Go to http://localhost:8080/echo/hello");
	}

}
