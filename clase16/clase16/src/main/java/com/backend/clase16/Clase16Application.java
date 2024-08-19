package com.backend.clase16;

import com.backend.clase16.service.impl.EntrenadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Clase16Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Clase16Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Clase16Application.class, args);
		LOGGER.info("Clase16Application is now running...");
	}


}
