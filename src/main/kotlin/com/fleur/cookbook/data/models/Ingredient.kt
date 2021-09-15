package com.fleur.cookbook.data.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ingredients")
class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
        private set

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "calories")
    var calories: Int? = null

    @Column(name = "vegan")
    var vegan: Boolean? = null

    @Column(name = "vegetarian")
    private val vegetarian: Boolean? = null

    constructor(id: Long?, name: String?, calories: Int?, vegan: Boolean?) {
        this.id = id
        this.name = name
        this.calories = calories
        this.vegan = vegan
    }

    constructor(name: String?, calories: Int?, vegan: Boolean?) {
        this.name = name
        this.calories = calories
        this.vegan = vegan
    }

    constructor() {}

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ingredient

        if (id != other.id) return false
        if (name != other.name) return false
        if (calories != other.calories) return false
        if (vegan != other.vegan) return false
        if (vegetarian != other.vegetarian) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (calories ?: 0)
        result = 31 * result + (vegan?.hashCode() ?: 0)
        result = 31 * result + (vegetarian?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Ingredient(id=$id, name=$name, calories=$calories, vegan=$vegan, vegetarian=$vegetarian)"
    }
}
