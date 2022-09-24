package com.example.todolistv2.domain.auth.data

import com.example.todolistv2.domain.auth.type.Role
import java.time.LocalDateTime

class Admin(
    accountId: String,
    password: String,
    nickname: String,
    createdBy: Long,
    createdAt: LocalDateTime
): User(
    accountId = accountId,
    password = password,
    nickname = nickname,
    role = Role.ADMIN,
    createdBy = createdBy,
    createdAt = createdAt
) {}