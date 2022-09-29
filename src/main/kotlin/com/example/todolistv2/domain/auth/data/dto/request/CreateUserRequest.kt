package com.example.todolistv2.domain.auth.data.dto.request

import javax.validation.constraints.Pattern

data class CreateUserRequest(

    val nickname: String,

    @field:Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$",
        message = "이메일 형식이여야 합니다 (ex :: abc123@gmail.com)")
    val accountId: String,

    @field:Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d~!@#\$%^&*()+|=]{8,30}\$",
        message = "영 대/소문자, 숫자, 특수문자 포함 총 8자 이상 입력해야합니다")
    val password: String
)
