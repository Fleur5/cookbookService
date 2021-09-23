package com.fleur.cookbook.rest.service

import com.fleur.cookbook.data.models.FullRecipe
import com.fleur.cookbook.data.models.Recipe
import com.fleur.cookbook.data.repositories.FullRecipeRepository
import com.fleur.cookbook.data.repositories.IngredientRepository
import com.fleur.cookbook.data.repositories.RecipeRepository
import com.fleur.cookbook.data.repositories.TagRepository
import com.fleur.cookbook.rest.models.RecipeRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class RecipeService {
    @Autowired
    lateinit var recipeRepository: RecipeRepository

    @Autowired
    lateinit var fullRecipeRepository: FullRecipeRepository

    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    @Autowired
    lateinit var tagRepository: TagRepository

    fun getAllRecipes(page: Int, size: Int): Page<Recipe?> =
        recipeRepository.findAll(PageRequest.of(page, size, Sort.by("name")))

    fun findRecipeById(id: Int) = recipeRepository.findById(id)

    fun findRecipeByName(name: String) = recipeRepository.findAllByName(name).sortedBy { it?.id }

    fun saveRecipeFromRequest(recipeRequest: RecipeRequest) {
        val recipe = Recipe(recipeRequest, tagRepository.findAllById(recipeRequest.tags))
        recipeRepository.save(recipe)
        recipeRequest.ingredients.forEach { (id, amount) ->
            val ingredient = ingredientRepository.findById(id)
            if (ingredient.isPresent) fullRecipeRepository.save(FullRecipe(recipe, ingredient.get(), amount))
        }
    }
}