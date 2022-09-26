package com.example.todolistv2.domain.auth.service

import com.example.todolistv2.domain.auth.data.dto.request.CreateUserRequest
import com.example.todolistv2.domain.auth.data.dto.request.EditUserNickNameRequest

interface GeneralService {

    fun join(request: CreateUserRequest)

    fun editNickname(request: EditUserNickNameRequest)

}