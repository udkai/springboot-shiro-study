package com.balance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class Day01Application {

	@RequestMapping("/hello")
	public String test(){
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(Day01Application.class, args);
	}
}
