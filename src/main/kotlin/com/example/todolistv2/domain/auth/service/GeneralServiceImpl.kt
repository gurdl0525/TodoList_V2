package com.example.todolistv2.domain.auth.service

import com.example.todolistv2.domain.auth.data.dto.request.CreateUserRequest
import com.example.todolistv2.domain.auth.data.dto.request.EditUserNickNameRequest
import com.example.todolistv2.domain.auth.data.entity.General
import com.example.todolistv2.domain.auth.repository.UserRepository
import com.example.todolistv2.domain.auth.data.entity.type.Role
import com.example.todolistv2.global.util.UserFacade
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GeneralServiceImpl(
    private val userRepository: UserRepository<General>,
    private val passwordEncoder: PasswordEncoder,
    private val userFacade: UserFacade
): GeneralService {

    override fun join(request: CreateUserRequest) {
        userRepository.save(
            General(
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                nickname = request.nickname,
                role = Role.NORMAL,
                createdAt = LocalDateTime.now()
        ))
    }

    override fun editNickname(request: EditUserNickNameRequest) {
        val user = userFacade.getCurrentUser()
        user.editNickname(nickname = request.nickname)
        user.updated(LocalDateTime.now())
    }

}