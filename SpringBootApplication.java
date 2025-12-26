package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("1234"));

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (encoder.matches(null,null)) {
			System.err.println("Password Matched");
		} else {
			System.out.println("No Match ");
		}
	}

}