package com.eksad.latihanrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eksad.latihanrest.dao.ProductDao;

@SpringBootApplication
public class LatihanrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatihanrestApplication.class, args);
	}

	@Autowired
	private ProductDao productDao;

}
