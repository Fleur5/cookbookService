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
        @RequestParam("name") name: String?
    ) =
        if (name == null) tagService.getAllTags(page, size)
        else tagService.findTagByName(name)

    @GetMapping("/{id}")
    fun getTagById(@PathVariable("id") id: Int) = tagService.findTagById(id)

    @GetMapping("/{name}")
    fun getTagByName(@PathVariable("name") name: String) = tagService.findTagByName(name)

    @PostMapping
    fun saveTag(@RequestBody tag: Tag) = tagService.saveTagFromRequest(tag)
}