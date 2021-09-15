package com.fleur.cookbook.data.models

import com.fasterxml.jackson.databind.JsonNode
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "recipe")
class Recipe (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = -1,

    @Column(name = "name", nullable = false)
    var name: String = "",

    @Column(name = "preparation_duration")
    var preparationDuration: Int? = null,

    @Column(name = "waiting_time")
    var waitingTime: Int? = null,

    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonBinaryType")
    @Column(name = "preparation_steps", nullable = false)
    var preparationSteps: JsonNode
)