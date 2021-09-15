package com.fleur.cookbook.data.models

import javax.persistence.*

@Entity
@Table(name = "ingredient")
class Ingredient (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "calories")
    var calories: Int? = null,

    @Column(name = "vegan")
    var vegan: Boolean? = null,

    @Column(name = "vegetarian")
    var vegetarian: Boolean? = null,
)
