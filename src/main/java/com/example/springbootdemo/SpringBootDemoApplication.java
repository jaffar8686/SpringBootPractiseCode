package com.example.springbootdemo;


/*
*  This project basically includes javax.validation and patch mapping
*
*  It also includes Rest template for consuming web services
*
*  Dummy apis  `https://dummy.restapiexample.com/api/v1/employees   `\
*               https://dummy.restapiexample.com/api/v1/create
*               https://dummy.restapiexample.com/api/v1/employee/1
*
* */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();

	}

}
