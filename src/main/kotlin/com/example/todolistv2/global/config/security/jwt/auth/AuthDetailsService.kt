package com.example.todolistv2.global.config.security.jwt.auth

import com.example.todolistv2.domain.auth.data.entity.User
import com.example.todolistv2.domain.auth.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository<User>
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByAccountId(username)
            .map { AuthDetails(user = it) }
            .orElseThrow { UsernameNotFoundException("NOT FOUND USERNAME") }
    }

}