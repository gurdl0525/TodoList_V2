package com.example.todolistv2.global.error.data

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,
    val status: HttpStatus
) {
    //400
    DUPLICATE_NICKNAME("duplicated nickname", HttpStatus.BAD_REQUEST),

    //401
    UN_AUTHORIZED("un authorized", HttpStatus.UNAUTHORIZED),

    //404
    ENTITY_NOT_FOUND("entity not found", HttpStatus.NOT_FOUND)
}