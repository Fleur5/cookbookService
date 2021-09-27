package com.fleur.cookbook.data.models.serializers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.fleur.cookbook.data.models.Tag

class TagSerializer : StdSerializer<Tag>(Tag::class.java) {
    override fun serialize(tag: Tag?, jsonGenerator: JsonGenerator?, p2: SerializerProvider?) {
        jsonGenerator?.let { jGen ->
            tag?.let { tag ->
                jGen.writeStartObject()
                jGen.writeNumberField("id", tag.id ?: -1)
                jGen.writeStringField("name", tag.name)
                jGen.writeStartArray()
                tag.recipes.forEach { fullRecipe ->
                    jGen.writeStartObject()
                    jGen.writeNumberField("id", fullRecipe.id ?: -1)
                    jGen.writeStringField("name", fullRecipe.name)
                    jGen.writeEndObject()
                }
                jGen.writeEndArray()
                jGen.writeEndObject()
            }
        }
    }
}