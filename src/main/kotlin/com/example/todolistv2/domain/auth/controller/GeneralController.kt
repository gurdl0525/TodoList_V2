package com.example.todolistv2.domain.auth.controller

import com.example.todolistv2.domain.auth.data.dto.request.CreateUserRequest
import com.example.todolistv2.domain.auth.data.dto.request.EditUserNickNameRequest
import com.example.todolistv2.domain.auth.service.GeneralService
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class GeneralController(
    private val generalService: GeneralService
) {

    @PostMapping("/sign-up")
    fun join(request: CreateUserRequest){
        generalService.join(request)
    }

    @PatchMapping("/retouch/nickname")
    fun editNickname(request: EditUserNickNameRequest){
        generalService.editNickname(request)
    }
}