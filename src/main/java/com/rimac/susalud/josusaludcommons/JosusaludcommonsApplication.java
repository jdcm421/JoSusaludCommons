package com.rimac.susalud.josusaludcommons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JosusaludcommonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JosusaludcommonsApplication.class, args);
	}

}
