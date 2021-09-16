package com.fleur.cookbook.data.models

import javax.persistence.*

@Table(name = "ingredient")
@Entity
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
        orphanRemoval = true
    )
    var recipes: MutableSet<FullRecipe> = mutableSetOf()
}