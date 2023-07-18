package com.clinton.gestiondedocuments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiGestionDeDocumentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestionDeDocumentsApplication.class, args);
	}

}
