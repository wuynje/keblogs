package com.yjytke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.yjytke.dao")
@EnableCaching
public class KeblogsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(KeblogsApplication.class, args);
	}
	
	 @Override//为了打包springboot项目
	    protected SpringApplicationBuilder configure(
	            SpringApplicationBuilder builder) {
	        return builder.sources(this.getClass());
	    }
}
