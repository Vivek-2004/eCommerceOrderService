package com.example.orderservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class OrderserviceApplication {
	public static void main(String[] args) {
		Dotenv dotEnv = Dotenv.configure().load();
		dotEnv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(OrderserviceApplication.class, args);
		System.out.println(dotEnv.get("PORT"));
	}
}