package com.fleur.cookbook.data.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fleur.cookbook.data.models.serializers.IngredientSerializer
import javax.persistence.*

@Table(name = "ingredient")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id", scope = Int::class)
@JsonSerialize(using = IngredientSerializer::class)
class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "calories")
    var calories: Int? = null

    @Column(name = "vegan")
    var vegan: Boolean? = false

    @Column(name = "vegetarian")
    var vegetarian: Boolean? = false

    @OneToMany(
        mappedBy = "ingredient",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH],
        orphanRemoval = true, fetch = FetchType.EAGER
    )
    var recipes: MutableSet<FullRecipe> = mutableSetOf()
}