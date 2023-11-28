package com.example.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Department Service REST APIs",
				description = "Department Service REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sindu",
						email = "sindhupriya.kona@gmail.com",
						url = "https://www.springboot.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.springboot.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department Service Documentation",
				url = "https://www.springboot.net"
		)
)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
