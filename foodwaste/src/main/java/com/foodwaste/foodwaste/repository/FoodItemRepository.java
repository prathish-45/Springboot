package com.foodwaste.foodwaste.repository;

import com.foodwaste.foodwaste.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {}