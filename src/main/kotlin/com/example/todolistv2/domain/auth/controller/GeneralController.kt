package com.example.todolistv2.domain.auth.controller

import com.example.todolistv2.domain.auth.data.dto.request.CreateUserRequest
import com.example.todolistv2.domain.auth.data.dto.request.EditUserNickNameRequest
import com.example.todolistv2.domain.auth.service.GeneralService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class GeneralController(
    private val generalService: GeneralService
) {

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun join(@RequestBody request: CreateUserRequest){
        generalService.join(request)
    }

    @PatchMapping("/retouch/nickname")
    fun editNickname(@RequestBody request: EditUserNickNameRequest){
        generalService.editNickname(request)
    }
}