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
    fun getAllIngredients(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
        @RequestParam("name") name: String?
    ) =
        if (name == null) ingredientService.getAllIngredients(page, size)
        else ingredientService.findIngredientByName(name)

    @GetMapping("/{id}")
    fun getIngredientById(@PathVariable("id") id: Int) = ingredientService.findIngredientById(id)

    @PostMapping("")
    fun saveIngredient(@RequestBody ingredient: Ingredient) = ingredientService.saveIngredient(ingredient)
}