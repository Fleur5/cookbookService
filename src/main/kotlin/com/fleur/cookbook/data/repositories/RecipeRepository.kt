package com.fleur.cookbook.data.repositories

import com.fleur.cookbook.data.models.Recipe
import org.springframework.data.repository.PagingAndSortingRepository

interface RecipeRepository : PagingAndSortingRepository<Recipe?, Long?> {
    fun findAllByName(name: String): List<Recipe?>
}