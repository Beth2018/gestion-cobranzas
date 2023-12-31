package com.cibertec.edu.pe.categories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCategoryApplication.class, args);
	}

}
