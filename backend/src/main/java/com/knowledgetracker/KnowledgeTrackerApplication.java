package com.knowledgetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KnowledgeTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeTrackerApplication.class, args);
	}

}
