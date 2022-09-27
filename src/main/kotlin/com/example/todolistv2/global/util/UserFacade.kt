package com.example.todolistv2.global.util

import com.example.todolistv2.domain.auth.data.entity.User
import com.example.todolistv2.domain.auth.repository.UserRepository
import com.example.todolistv2.global.error.exception.common.UnAuthorizedException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository<User>
) {

    fun getSubject(): String {
        return SecurityContextHolder.getContext()
            .authentication
            .credentials
            .toString()
    }

    fun getCurrentUser(): User {
        val subject = getSubject().toLong()
        return userRepository.findByIdOrNull(subject)
            ?:(throw UnAuthorizedException(subject.toString()))
    }
}