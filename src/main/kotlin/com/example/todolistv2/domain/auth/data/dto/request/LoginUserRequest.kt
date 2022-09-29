package com.example.todolistv2.domain.auth.data.dto.request

import javax.validation.constraints.NotBlank

data class LoginUserRequest(

    @field:NotBlank
    val accountId: String,

    @field:NotBlank
    val password: String
)
