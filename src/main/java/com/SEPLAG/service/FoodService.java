package com.SEPLAG.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SEPLAG.model.Food;
import com.SEPLAG.repository.FoodRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class FoodService {

	private final FoodRepository foodRepository;

	public FoodService(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	// Busca todas comidas cadastradas
	@GraphQLQuery(name = "foods")
	public List<Food> getFoods() {
		return foodRepository.findAll();
	}

	// Busca comida por ID
	@GraphQLQuery(name = "food")
	public Optional<Food> getFoodById(@GraphQLArgument(name = "id") Long id) {
		return foodRepository.findById(id);
	}

	// Cria comida
	@GraphQLMutation(name = "saveFood")
	public Food saveFood(@GraphQLArgument(name = "food") Food food) {
		return foodRepository.save(food);
	}

	// Deleta comida
	@GraphQLMutation(name = "deleteFood")
	public void deleteFood(@GraphQLArgument(name = "id") Long id) {
		foodRepository.deleteById(id);
	}

	// Busca todas comidas cadastradas
	@GraphQLQuery(name = "isGood")
	public boolean isGood(@GraphQLContext Food food) {
		return !Arrays.asList("Fígado", "Spam").contains(food.getNome());
	}
}
