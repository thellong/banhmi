package com.thellong.banhmi.model.repos;

import org.springframework.data.repository.CrudRepository;

import com.thellong.banhmi.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
    
}
