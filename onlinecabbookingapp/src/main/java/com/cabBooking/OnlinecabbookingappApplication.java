package com.cabBooking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2

public class OnlinecabbookingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinecabbookingappApplication.class, args);
		System.out.println("Online Booking  Cab Application Server Started");
	}

	
}
