package com.cibertec.edu.pe.persons;

import com.cibertec.edu.pe.persons.dao.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApiPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPersonApplication.class, args);
	}

	@Bean
	LettuceConnectionFactory lettuceConnectionFactory(int database, String hostname, int port) {
		RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
		rsc.setDatabase(database);
		rsc.setHostName(hostname);
		rsc.setPort(port);
		return new LettuceConnectionFactory(rsc);
	}

	@Bean
	public RedisTemplate<String, Person> redisTemplate(
			@Value("${spring.redis.database}") int database,
			@Value("${spring.redis.host}") String hostname,
			@Value("${spring.redis.port}") int port
	) {
		RedisTemplate<String, Person> template = new RedisTemplate<>();
		template.setConnectionFactory(lettuceConnectionFactory(database, hostname, port));
		template.afterPropertiesSet();
		return template;
	}
}
