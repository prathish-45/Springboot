package com.foodwaste.foodwaste.controller;

// package com.foodwaste.foodwaste.controller;

import com.foodwaste.foodwaste.model.FoodItem;
import com.foodwaste.foodwaste.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodwaste/food")
public class FoodController {

    @Autowired
    private FoodItemRepository foodRepo;

    @PostMapping
    public String addFood(@RequestBody FoodItem foodItem) {
        foodRepo.save(foodItem);
        return "Food item added successfully!";
    }

    @GetMapping
    public List<FoodItem> getAllFood() {
        return foodRepo.findAll();
    }
}
