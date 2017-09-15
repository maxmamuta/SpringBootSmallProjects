package com.example.demo;

import com.example.demo.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Testbd2Application {
	public static final Logger log = LoggerFactory.getLogger(Testbd2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Testbd2Application.class, args);
	}

	@Bean
	CommandLineRunner start(JournalService service) {
		return args-> {
			log.info("@@ Inserting Data...");
			service.insertData();
			log.info("@@ findAll() call");
			service.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
}
