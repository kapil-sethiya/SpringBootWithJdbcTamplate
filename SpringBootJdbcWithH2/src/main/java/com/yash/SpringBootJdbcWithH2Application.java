package com.yash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yash.dto.Student;
import com.yash.repositary.StudentJdbcRepository;

@SpringBootApplication
public class SpringBootJdbcWithH2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcWithH2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Arguments -------"+args.length);
		
		logger.info("Student id 10001 -> {}", repository.insert(new Student(10001L,"gourav","A1234567")));

		logger.info("Student id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "John", "A1234657")));

		logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

		logger.info("Delete 10002L -> {}",repository.deleteById(10002L));

		logger.info("All users -> {}", repository.findAll());

	}
}
