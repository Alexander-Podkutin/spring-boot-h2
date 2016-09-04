package com.podkutin;

import com.google.common.collect.Lists;
import com.podkutin.entities.ClientDO;
import com.podkutin.entities.OrderDO;
import com.podkutin.repositories.ClientRepository;
import com.podkutin.repositories.OrderRepository;
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
	public CommandLineRunner demo(ClientRepository clientRepository, OrderRepository orderRepository) {
		return (args) -> {
			ClientDO clientOne = new ClientDO("john111", "John", "Smith");
			ClientDO clientTwo = new ClientDO("billT1990", "Bill", "Turner");
			ClientDO clientThree = new ClientDO("robin.alex", "Alex", "Robinson");

			clientOne.setOrdersDO(Lists.newArrayList(new OrderDO("111-1", clientOne),
					new OrderDO("222-2", clientOne)));
			clientTwo.setOrdersDO(Lists.newArrayList(new OrderDO("333-1-1", clientTwo),
					new OrderDO("444-2", clientTwo)));
			clientThree.setOrdersDO(Lists.newArrayList(new OrderDO("555-1", clientThree),
					new OrderDO("6666-2", clientThree), new OrderDO("777-2", clientThree)));

			clientRepository.save(Lists.newArrayList(clientOne, clientTwo, clientThree));
			
			log.info("Show all clients: ");
			log.info("-------------------");
			for (ClientDO clientDO : clientRepository.findAll()) {
				log.info(clientDO.toString());
			}
		};


	}



}
