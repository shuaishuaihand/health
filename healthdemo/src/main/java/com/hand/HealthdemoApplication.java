package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCaching  //开启缓存注解
//@EnableEurekaClient
@SpringBootApplication
public class HealthdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthdemoApplication.class, args);
	}
}
