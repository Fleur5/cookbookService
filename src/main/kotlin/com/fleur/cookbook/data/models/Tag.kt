package com.fleur.cookbook.data.models

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fleur.cookbook.data.models.serializers.TagSerializer
import javax.persistence.*

@Table(name = "tag")
@Entity
@JsonSerialize(using = TagSerializer::class)
class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null

    @Lob
    @Column(name = "name")
    var name: String? = null


    @ManyToMany
    @JoinTable(
        name = "recipe_tag",
        joinColumns = [JoinColumn(name = "tag_id")],
        inverseJoinColumns = [JoinColumn(name = "recipe_id")]
    )
    var recipes: MutableSet<Recipe> = mutableSetOf()
}