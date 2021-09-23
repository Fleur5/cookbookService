package com.fleur.cookbook.data.repositories

import com.fleur.cookbook.data.models.Tag
import org.springframework.data.repository.PagingAndSortingRepository

interface TagRepository : PagingAndSortingRepository<Tag, Int> {
    fun findAllByName(name: String): List<Tag?>
}