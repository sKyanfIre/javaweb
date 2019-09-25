package com.zzz.springeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringeurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeurekaclientApplication.class, args);
	}

}
