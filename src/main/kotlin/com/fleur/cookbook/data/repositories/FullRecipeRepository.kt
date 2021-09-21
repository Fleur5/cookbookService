package com.fleur.cookbook.data.repositories

import com.fleur.cookbook.data.models.FullRecipe
import org.springframework.data.repository.PagingAndSortingRepository

interface FullRecipeRepository : PagingAndSortingRepository<FullRecipe?, Long?> {
}