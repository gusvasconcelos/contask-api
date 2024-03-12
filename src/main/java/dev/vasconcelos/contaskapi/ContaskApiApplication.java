package dev.vasconcelos.contaskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContaskApiApplication {
	public String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(ContaskApiApplication.class, args);
	}

}
