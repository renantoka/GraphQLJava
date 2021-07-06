package com.SEPLAG;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SEPLAG.model.Food;
import com.SEPLAG.service.FoodService;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(FoodService foodService) {
        return args -> {
            Stream.of("Pizza", "Fígado", "Ovos", "Abacate").forEach(name -> {
                Food food = new Food();
                food.setNome(name);
                foodService.saveFood(food);
            });
            foodService.getFoods().forEach(System.out::println);
        };
    }

}
