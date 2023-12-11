package com.Zomato.Authservicezomato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class AuthServiceZomatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceZomatoApplication.class, args);
	}

}
