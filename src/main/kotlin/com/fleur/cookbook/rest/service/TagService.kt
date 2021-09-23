package com.fleur.cookbook.rest.service

import com.fleur.cookbook.data.models.Tag
import com.fleur.cookbook.data.repositories.TagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class TagService {
    @Autowired
    lateinit var tagRepository: TagRepository

    fun getAllTags(page: Int, size: Int): Page<Tag?> =
        tagRepository.findAll(PageRequest.of(page, size, Sort.by("name")))

    fun findTagById(id: Int) = tagRepository.findById(id)

    fun findTagByName(name: String) = tagRepository.findAllByName(name)

    fun saveTagFromRequest(tag: Tag) = tagRepository.save(tag)
}