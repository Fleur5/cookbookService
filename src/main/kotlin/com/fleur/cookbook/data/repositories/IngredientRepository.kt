package com.fleur.cookbook.data.repositories

import com.fleur.cookbook.data.models.Ingredient
import org.springframework.data.repository.PagingAndSortingRepository

interface IngredientRepository : PagingAndSortingRepository<Ingredient?, Long?> {
    fun findAllByName(name: String): List<Ingredient?>
}
