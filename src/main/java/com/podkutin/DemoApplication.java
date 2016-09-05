package com.podkutin;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.podkutin.entities.ClientDO;
import com.podkutin.entities.ItemDO;
import com.podkutin.entities.OrderDO;
import com.podkutin.repositories.ClientRepository;
import com.podkutin.repositories.ItemRepository;
import com.podkutin.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository,
								  OrderRepository orderRepository,
								  ItemRepository itemRepository) {
		return (args) -> {
			ClientDO clientOne = new ClientDO("john111", "John", "Smith");
			ClientDO clientTwo = new ClientDO("billT1990", "Bill", "Turner");
			ClientDO clientThree = new ClientDO("robin.alex", "Alex", "Robinson");

			OrderDO orderOne = new OrderDO("111-1", clientOne);
			OrderDO orderTwo = new OrderDO("222-2", clientOne);
			OrderDO orderThree = new OrderDO("333-1-1", clientTwo);
			OrderDO orderFour = new OrderDO("444-2", clientTwo);
			OrderDO orderFive = new OrderDO("555-1", clientThree);
			OrderDO orderSix = new OrderDO("6666-2", clientThree);
			OrderDO orderSeven = new OrderDO("777-2", clientThree);


			Set<ItemDO> itemsDO = Sets.newHashSet(new ItemDO("Table", orderOne, 1),
					new ItemDO("Chair", orderTwo, 4),
					new ItemDO("Door", orderThree, 2),
					new ItemDO("Desk", orderThree, 1),
					new ItemDO("Cabinet", orderFour, 2),
					new ItemDO("Bookshelf", orderFive, 1),
					new ItemDO("Bed", orderSix, 1),
					new ItemDO("Sofa", orderSeven, 2));

			clientRepository.save(Lists.newArrayList(clientOne, clientTwo, clientThree));
			orderRepository.save(Lists.newArrayList(
					orderOne, orderTwo, orderThree, orderFour, orderFive, orderSix, orderSeven));
			itemRepository.save(itemsDO);
			
			log.info("Show all clients, with orders and items: ");
			log.info("-------------------");
			for (ClientDO clientDO : clientRepository.findAll()) {
				log.info(clientDO.toString());
			}
		};


	}



}
