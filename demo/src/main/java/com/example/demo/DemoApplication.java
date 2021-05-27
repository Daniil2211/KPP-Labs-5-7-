package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = Logger.getLogger(DemoApplication.class);

	public static void main(String[] args) {

		log.debug("Start program");

		SpringApplication.run(DemoApplication.class, args);
	}

}
