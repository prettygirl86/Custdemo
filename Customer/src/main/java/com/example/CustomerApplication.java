package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import com.example.controller.CustomerController;

@SpringBootApplication
//@ComponentScan({"com.example.*"})
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
		System.out.println("Customer Application!!!");
	}
}
