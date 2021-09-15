package com.fleur.cookbook.rest.service

import com.fleur.cookbook.data.models.Ingredient
import com.fleur.cookbook.data.repositories.IngredientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service


@Service
class IngredientService {
    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    fun getAllIngredients(page: Int, size: Int): MutableIterable<Ingredient?> =
        ingredientRepository.findAll(PageRequest.of(page, size, Sort.by("name")))

    fun findIngredientByName(name: String) = ingredientRepository.findAllByName(name).sortedBy { it?.id }

    fun saveIngredient(ingredient: Ingredient) = ingredientRepository.save(ingredient)
}
