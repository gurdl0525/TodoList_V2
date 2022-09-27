package com.example.todolistv2.domain.auth.service

import com.example.todolistv2.domain.auth.data.dto.request.CheckNicknameRequest
import com.example.todolistv2.domain.auth.data.dto.request.CreateUserRequest
import com.example.todolistv2.domain.auth.data.dto.request.EditUserNickNameRequest
import com.example.todolistv2.domain.auth.data.dto.request.LoginUserRequest
import com.example.todolistv2.domain.auth.data.dto.response.TokenResponse

interface GeneralService {

    fun join(request: CreateUserRequest)

    fun editNickname(request: EditUserNickNameRequest)

    fun checkDuplicate(request: CheckNicknameRequest)

    fun login(request: LoginUserRequest): TokenResponse

}