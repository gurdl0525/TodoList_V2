package com.example.todolistv2.domain.auth.data.dto.request

import javax.validation.constraints.NotBlank

data class CheckNicknameRequest(
    @field:NotBlank
    val nickname: String
)
