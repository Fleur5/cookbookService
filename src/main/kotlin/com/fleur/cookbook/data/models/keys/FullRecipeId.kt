package com.fleur.cookbook.data.models.keys

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class FullRecipeId : Serializable {
    @Column(name = "recipe_id", nullable = false)
    var recipeId: Int? = null

    @Column(name = "ingredient_id", nullable = false)
    var ingredientId: Int? = null

    override fun hashCode(): Int = Objects.hash(recipeId, ingredientId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as FullRecipeId

        return recipeId == other.recipeId &&
                ingredientId == other.ingredientId
    }

    companion object {
        private const val serialVersionUID = -5455220081055349676L
    }
}