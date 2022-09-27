package com.example.todolistv2.domain.auth.repository

import com.example.todolistv2.domain.auth.data.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository<T: User>: JpaRepository<T, Long> {

    fun findByAccountId(accountId: String): Optional<T>

    fun existsByNickname(nickname: String): Boolean

}