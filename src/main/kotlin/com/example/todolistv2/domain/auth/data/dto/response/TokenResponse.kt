package com.example.todolistv2.domain.auth.data.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)
