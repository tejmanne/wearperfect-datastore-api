package com.wearperfect.datastoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author teja
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.wearperfect.datastoreapi.repositories")
public class WearPerfectDatastoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WearPerfectDatastoreApiApplication.class, args);
	}

}
