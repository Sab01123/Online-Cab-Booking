package com.cabBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication

public class OnlinecabbookingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinecabbookingappApplication.class, args);
		System.out.println("Online Booking Cab Application Server Started");
	}

}
