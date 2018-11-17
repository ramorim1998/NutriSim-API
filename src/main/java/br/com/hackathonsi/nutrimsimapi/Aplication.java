package br.com.hackathonsi.nutrimsimapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Aplication {
	public static void main(String[] args) {
		SpringApplication.run(Aplication.class, args);
	}
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Aplication.class);
    }
}
