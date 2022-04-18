package com.tourism;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourism.domain.Item;
import com.tourism.domain.ItemResponse;
import com.tourism.domain.ItemsRequest;
import com.tourism.service.ItemService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Tourism API",
        version = "1.0.0",
        description = "Tourism API Documentation"))
public class TourismAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourismAppApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(ItemService itemService, ObjectMapper mapper) {

        return args -> {
            ItemsRequest itemsRequest = new ItemsRequest();
            List<Item> items = List.of(
                new Item("map",90,150),
                new Item("compass",130,35),
                new Item("water",1530,200),
                new Item("sandwich",500,160),
                new Item("glucose",150,60),
                new Item("tin",680,45),
                new Item("banana",270,60),
                new Item("apple",390,40),
                new Item("cheese",230,30),
                new Item("beer",520,10),
                new Item("suntan cream",110,70),
                new Item("camera",320,30),
                new Item("T-shirt",240,15),
                new Item("trousers",480,10)
            );

            itemsRequest.setItems(items);
            ItemResponse itemResponse = itemService.getItemResponse(itemsRequest);

            String valueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(itemResponse);
            System.out.println(valueAsString);
        };
    }

}
