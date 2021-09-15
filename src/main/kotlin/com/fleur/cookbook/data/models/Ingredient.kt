package com.fleur.cookbook.data.models

import javax.persistence.*

@Entity
@Table(name = "ingredient")
class Ingredient (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = -1,

    @Column(name = "name", nullable = false)
    var name: String = "",

    @Column(name = "calories")
    var calories: Int? = null,

    @Column(name = "vegan")
    var vegan: Boolean? = false,

    @Column(name = "vegetarian")
    var vegetarian: Boolean? = false,
)
