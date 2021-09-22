package com.fleur.cookbook.rest.models.exceptions

import org.springframework.http.HttpStatus

data class GeneralErrorResponse(
    val status: HttpStatus,
    val message: String
)