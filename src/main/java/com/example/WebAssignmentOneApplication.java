package com.example;

import com.example.domain.ReviewRepository;
import com.example.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAssignmentOneApplication implements CommandLineRunner{

	@Autowired
	private ReviewRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WebAssignmentOneApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		for (int i = 0; i < 5; i++){
			repository.save(new Review("My Review number #" + (i+1)));
		}
	}
}
