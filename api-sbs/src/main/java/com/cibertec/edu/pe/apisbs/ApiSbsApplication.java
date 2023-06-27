package com.cibertec.edu.pe.apisbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiSbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSbsApplication.class, args);
	}

}
