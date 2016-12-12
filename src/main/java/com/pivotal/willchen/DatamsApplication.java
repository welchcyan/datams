package com.pivotal.willchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableDiscoveryClient
@EnableAutoConfiguration
public class DatamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatamsApplication.class, args);
	}


}
