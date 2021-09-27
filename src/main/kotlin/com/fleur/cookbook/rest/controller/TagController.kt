package com.fleur.cookbook.rest.controller

import com.fleur.cookbook.data.models.Tag
import com.fleur.cookbook.rest.service.TagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/tag")
class TagController {

    @Autowired
    lateinit var tagService: TagService

    @GetMapping
    fun getAllTags(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
    ) = tagService.getAllTags(page, size)

    @GetMapping("/{id}")
    fun getTagById(@PathVariable("id") id: Int) = tagService.findTagById(id)

    @PostMapping
    fun saveTag(@RequestBody tag: Tag) = tagService.saveTagFromRequest(tag)
}