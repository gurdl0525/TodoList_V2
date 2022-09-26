package com.example.todolistv2.domain.auth.data.dto.request

data class CreateUserRequest(
    val nickname: String,
    val accountId: String,
    val password: String
)
