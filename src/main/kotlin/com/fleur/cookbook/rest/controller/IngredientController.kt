package com.fleur.cookbook.rest.controller

import com.fleur.cookbook.data.models.Ingredient
import com.fleur.cookbook.rest.service.IngredientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/ingredient")
class IngredientController {

    @Autowired
    lateinit var ingredientService: IngredientService

    @GetMapping("")
    fun getAllIngredients() = ingredientService.getAllIngredients()

    @GetMapping("/{name}")
    fun getIngredientByName(@PathVariable("name") name: String) = ingredientService.findIngredientByName(name)

    @PostMapping("")
    fun postIngredient(@RequestBody ingredient: Ingredient) = ingredientService.saveIngredient(ingredient)
}