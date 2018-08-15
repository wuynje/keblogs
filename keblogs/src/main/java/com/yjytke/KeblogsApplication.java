package com.yjytke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yjytke.dao")
public class KeblogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeblogsApplication.class, args);
	}
}
