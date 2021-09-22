package com.fleur.cookbook.rest.models

import com.fasterxml.jackson.databind.JsonNode

data class RecipeRequest(
    var name: String,

    var preparationDuration: Int? = null,

    var waitingTime: Int? = null,

    var preparationSteps: JsonNode,

    var ingredients: Map<Int, Double>
)