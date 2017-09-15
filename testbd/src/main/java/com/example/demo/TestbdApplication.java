package com.example.demo;

import com.example.demo.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestbdApplication implements CommandLineRunner {
	public static final Logger log = LoggerFactory.getLogger(TestbdApplication.class);

	@Autowired
	JournalService service;

	public static void main(String[] args) {
		SpringApplication.run(TestbdApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {
		log.info("@@ Inserting Data....");
		service.insertData();
		log.info("@@ findAll() call");
		service.findAll().forEach(entry -> log.info(entry.toString()));
	}
}
