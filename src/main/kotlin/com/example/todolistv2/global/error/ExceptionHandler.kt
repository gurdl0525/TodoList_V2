package com.example.todolistv2.global.error

import com.example.todolistv2.global.error.data.ErrorResponse
import com.example.todolistv2.global.error.exception.GlobalException
import org.springframework.context.support.DefaultMessageSourceResolvable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    e.bindingResult.allErrors
                        .map {DefaultMessageSourceResolvable::getDefaultMessage}
                        .toString(),
                    e.bindingResult.allErrors
                        .map { it.arguments }
                        .toString()
                )
            )
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun methodArgumentNotValidException(e: ConstraintViolationException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    e.constraintViolations
                        .map { it.messageTemplate }
                        .toString(),
                    e.constraintViolations
                        .map { it.rootBeanClass }
                        .toString()
                )
            )
    }
}