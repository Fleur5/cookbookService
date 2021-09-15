package com.fleur.cookbook.data.repositories

import com.fleur.cookbook.data.models.Ingredient
import org.springframework.data.jpa.repository.JpaRepository


interface IngredientRepository : JpaRepository<Ingredient?, Long?> {
    fun findAllByName(name: String?): List<Ingredient?>?
}
