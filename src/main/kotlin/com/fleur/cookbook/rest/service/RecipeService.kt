package com.fleur.cookbook.rest.service

import com.fleur.cookbook.data.models.Recipe
import com.fleur.cookbook.data.repositories.RecipeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class RecipeService {
    @Autowired
    lateinit var recipeRepository: RecipeRepository

    fun getAllRecipes(page: Int, size: Int): Page<Recipe?> =
        recipeRepository.findAll(PageRequest.of(page, size, Sort.by("name")))

    fun findRecipeByName(name: String) = recipeRepository.findAllByName(name).sortedBy { it?.id }

    fun saveRecipe(recipe: Recipe) = recipeRepository.save(recipe)
}