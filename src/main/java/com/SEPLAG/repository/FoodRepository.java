package com.SEPLAG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SEPLAG.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
