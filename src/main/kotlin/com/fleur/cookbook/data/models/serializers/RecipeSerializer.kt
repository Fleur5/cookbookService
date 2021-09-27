package com.fleur.cookbook.data.models.serializers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fleur.cookbook.data.models.Recipe

class RecipeSerializer : StdSerializer<Recipe>(Recipe::class.java) {
    override fun serialize(recipe: Recipe?, jsonGenerator: JsonGenerator?, p2: SerializerProvider?) {
        jsonGenerator?.let { jGen ->
            recipe?.let { recipe ->
                jGen.writeStartObject()
                jGen.writeNumberField("id", recipe.id ?: -1)
                jGen.writeStringField("name", recipe.name)
                recipe.preparationDuration?.let { jGen.writeNumberField("preparationDuration", it) }
                recipe.waitingTime?.let { jGen.writeNumberField("waitingTime", it) }
                jGen.writeStringField("preparationSteps", recipe.preparationSteps?.toPrettyString())
                jGen.writeFieldName("ingredientList")
                jGen.writeStartArray()
                recipe.ingredients.forEach { fullRecipe ->
                    jGen.writeStartObject()
                    jGen.writeNumberField("amount", fullRecipe.amount ?: 0.0)
                    jGen.writeNumberField("id", fullRecipe.ingredient?.id ?: -1)
                    jGen.writeStringField("name", fullRecipe.ingredient?.name)
                    fullRecipe.ingredient?.calories?.let { jGen.writeNumberField("calories", it) }
                    jGen.writeBooleanField("vegetarian", fullRecipe.ingredient?.vegetarian ?: false)
                    jGen.writeBooleanField("vegan", fullRecipe.ingredient?.vegan ?: false)
                    jGen.writeEndObject()
                }
                jGen.writeEndArray()
                jGen.writeFieldName("tags")
                jGen.writeStartArray()
                recipe.tags.forEach { tag ->
                    jGen.writeStartObject()
                    jGen.writeNumberField("id", tag.id ?: -1)
                    jGen.writeStringField("name", tag.name)
                    jGen.writeEndObject()
                }
                jGen.writeEndArray()
                jGen.writeEndObject()
            }
        }
    }
}