package com.example.todolistv2.domain.auth.repository

import com.example.todolistv2.domain.auth.data.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository<T: User>: JpaRepository<T, Long> {
}