package com.fleur.cookbook.data.models.serializers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fleur.cookbook.data.models.Ingredient

class IngredientSerializer : StdSerializer<Ingredient>(Ingredient::class.java) {
    override fun serialize(ingredient: Ingredient?, jsonGenerator: JsonGenerator?, p2: SerializerProvider?) {
        jsonGenerator?.let { jGen ->
            ingredient?.let { ingredient ->
                jGen.writeStartObject()
                jGen.writeNumberField("id", ingredient.id ?: -1)
                jGen.writeStringField("name", ingredient.name)
                ingredient.calories?.let { jGen.writeNumberField("calories", it) }
                jGen.writeBooleanField("vegetarian", ingredient.vegetarian ?: false)
                jGen.writeBooleanField("vegan", ingredient.vegan ?: false)
                jGen.writeFieldName("recipes")
                jGen.writeStartArray()
                ingredient.recipes.forEach { fullRecipe ->
                    jGen.writeStartObject()
                    jGen.writeNumberField("id", fullRecipe.recipe?.id ?: -1)
                    jGen.writeStringField("name", fullRecipe.recipe?.name)
                    jGen.writeEndObject()
                }
                jGen.writeEndArray()
                jGen.writeEndObject()
            }
        }
    }
}