package com.example.employeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sindu",
						email = "sindhupriya.kona@gmail.com",
						url = "com.example"
				),
				license = @License(
						name = "Apache 2.0",
						url = "com.example.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service Documentation",
				url = "com.example/employee-service/html"
		)
)
public class EmployeeServiceApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
