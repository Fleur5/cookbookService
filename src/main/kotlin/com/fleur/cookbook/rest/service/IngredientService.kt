package com.fleur.cookbook.rest.service

import com.fleur.cookbook.data.models.Ingredient
import com.fleur.cookbook.data.repositories.IngredientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class IngredientService {
    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    fun getAllIngredients(): MutableList<Ingredient?> = ingredientRepository.findAll()

    fun findIngredientByName(name: String?) = ingredientRepository.findAllByName(name)

    //fun saveIngredient(ingredient: Ingredient?) = ingredientRepository.save(ingredient)
}
