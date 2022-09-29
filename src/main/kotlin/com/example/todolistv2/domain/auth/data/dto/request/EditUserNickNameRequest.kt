package com.example.todolistv2.domain.auth.data.dto.request

import javax.validation.constraints.NotBlank

data class EditUserNickNameRequest(
    @field:NotBlank
    val nickname: String
)
