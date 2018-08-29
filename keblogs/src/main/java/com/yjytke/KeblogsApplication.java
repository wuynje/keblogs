package com.yjytke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.yjytke.dao")
@EnableCaching
public class KeblogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeblogsApplication.class, args);
	}
}
