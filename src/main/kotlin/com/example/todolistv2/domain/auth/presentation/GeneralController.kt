package com.example.todolistv2.domain.auth.presentation

import com.example.todolistv2.domain.auth.data.dto.request.CheckNicknameRequest
import com.example.todolistv2.domain.auth.data.dto.request.CreateUserRequest
import com.example.todolistv2.domain.auth.data.dto.request.EditUserNickNameRequest
import com.example.todolistv2.domain.auth.data.dto.request.LoginUserRequest
import com.example.todolistv2.domain.auth.data.dto.response.TokenResponse
import com.example.todolistv2.domain.auth.service.GeneralService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class GeneralController(
    private val generalService: GeneralService
) {

    @PostMapping("/duplicate/nickname")
    fun checkDuplicateNickname(@RequestBody @Validated request: CheckNicknameRequest){
        generalService.checkDuplicate(request)
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun join(@RequestBody @Validated request: CreateUserRequest){
        generalService.join(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Validated request: LoginUserRequest): TokenResponse{
        return generalService.login(request)
    }

    @PatchMapping("/retouch/nickname")
    fun editNickname(@RequestBody request: EditUserNickNameRequest){
        generalService.editNickname(request)
    }
}