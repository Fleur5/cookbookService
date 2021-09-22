package com.fleur.cookbook.data.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.fasterxml.jackson.databind.JsonNode
import com.fleur.cookbook.rest.models.RecipeRequest
import org.hibernate.annotations.Type
import javax.persistence.*

@Table(name = "recipe")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id", scope = Int::class)
class Recipe() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "preparation_duration")
    var preparationDuration: Int? = null

    @Column(name = "waiting_time")
    var waitingTime: Int? = null

    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType")
    @Column(name = "preparation_steps", nullable = false)
    var preparationSteps: JsonNode? = null

    @OneToMany(
        mappedBy = "recipe",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH],
        orphanRemoval = true, fetch = FetchType.EAGER
    )
    var ingredients: MutableSet<FullRecipe> = mutableSetOf()

    constructor(request: RecipeRequest) : this() {
        this.name = request.name
        this.preparationDuration = request.preparationDuration
        this.waitingTime = request.waitingTime
        this.preparationSteps = request.preparationSteps
    }
}