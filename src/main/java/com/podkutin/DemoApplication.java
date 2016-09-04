package com.podkutin;

import com.podkutin.entities.Client;
import com.podkutin.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository repository) {
		return (args) -> {
			repository.save(new Client("test1", "John", "Smith", null));
			repository.save(new Client("test2", "Bill", "Turner", null));
			repository.save(new Client("test3", "Alex", "Robinson", null));

			log.info("Show all clinets: ");
			log.info("-------------------");
			for (Client client : repository.findAll()) {
				log.info(client.toString());
			}
		};


	}



}
