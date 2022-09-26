package com.example.todolistv2.global.error.data

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,
    val status: HttpStatus
) {
    //401
    UN_AUTHORIZED("", HttpStatus.UNAUTHORIZED)
}