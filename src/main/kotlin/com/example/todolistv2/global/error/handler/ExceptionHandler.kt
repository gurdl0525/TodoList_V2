package com.example.todolistv2.global.error.handler

import com.example.todolistv2.global.error.data.ErrorResponse
import com.example.todolistv2.global.error.exception.GlobalException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(GlobalException::class)
    fun globalExceptionHandler(e: GlobalException): ResponseEntity<*>{
        return ResponseEntity.status(e.errorCode.status)
            .body(
                ErrorResponse(
                    e.errorCode.message,
                    e.data
                )
            )
    }
}