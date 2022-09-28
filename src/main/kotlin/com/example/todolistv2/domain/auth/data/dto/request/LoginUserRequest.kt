package com.example.todolistv2.domain.auth.data.dto.request

import javax.validation.constraints.NotBlank

data class LoginUserRequest(

    @NotBlank
    val accountId: String,

    @NotBlank
    val password: String
)
