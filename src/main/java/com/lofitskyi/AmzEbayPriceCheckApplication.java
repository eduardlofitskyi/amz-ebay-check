package com.lofitskyi;

import com.lofitskyi.entity.Item;
import com.lofitskyi.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AmzEbayPriceCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmzEbayPriceCheckApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ItemRepository itemRepository){
		return string -> Stream.of(	new Item("For Apple MacBook Pro Anti-Glare Screen Protector , 13.3",
				"http://www.ebay.com/itm/16-LED-Solar-Power-Motion-Sensor-Garden-Security-Lamp-Outdoor-Waterproof-Light-/311602370455?hash=item488cf2d797:g:078AAOSwLF1X2HE1",
				"", "MY_SKU", "1", "10"))
				.forEach(itemRepository::save);
	}
}
