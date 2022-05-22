package com.virtualghost.springmongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpingMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingMongoDemoApplication.class, args);
	}

}
