package com.whislley.bolton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.whislley.bolton.model.entity"})
public class BoltonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoltonApplication.class, args);
	}

}
