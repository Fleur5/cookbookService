package com.fleur.cookbook.data.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fleur.cookbook.data.models.keys.FullRecipeId
import javax.persistence.*


@Table(name = "full_recipe")
@Entity
class FullRecipe() {
    @JsonIgnore
    @EmbeddedId
    var id: FullRecipeId? = null

    @ManyToOne(
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH],
        optional = false
    )
    @JoinColumn(name = "recipe_id", nullable = false, insertable = false, updatable = false)
    var recipe: Recipe? = null

    @ManyToOne(
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH],
        optional = false
    )
    @JoinColumn(name = "ingredient_id", nullable = false, insertable = false, updatable = false)
    var ingredient: Ingredient? = null

    @Column(name = "amount_gram", nullable = false)
    var amount: Double? = null

    constructor(recipe: Recipe, ingredient: Ingredient, amount: Double) : this() {
        this.id = FullRecipeId(recipe.id, ingredient.id)
        this.recipe = recipe
        this.ingredient = ingredient
        this.amount = amount
    }
}