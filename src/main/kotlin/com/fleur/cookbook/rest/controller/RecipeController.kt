package com.fleur.cookbook.rest.controller

import com.fleur.cookbook.rest.models.RecipeRequest
import com.fleur.cookbook.rest.service.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/recipe")
class RecipeController {

    @Autowired
    lateinit var recipeService: RecipeService

    @GetMapping
    fun getAllRecipes(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
        @RequestParam("name") name: String?
    ) =
        if (name == null) recipeService.getAllRecipes(page, size)
        else recipeService.findRecipeByName(name)


    @GetMapping("/{id}")
    fun getRecipeById(@PathVariable("id") id: Int) = recipeService.findRecipeById(id)

    @PostMapping
    fun saveRecipe(@RequestBody recipe: RecipeRequest) = recipeService.saveRecipeFromRequest(recipe)
}