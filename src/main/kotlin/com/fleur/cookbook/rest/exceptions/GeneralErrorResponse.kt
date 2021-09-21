package com.fleur.cookbook.rest.exceptions

import org.springframework.http.HttpStatus

data class GeneralErrorResponse(
    val status: HttpStatus,
    val message: String
)