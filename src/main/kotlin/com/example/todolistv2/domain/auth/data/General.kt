package com.example.todolistv2.domain.auth.data

import com.example.todolistv2.domain.auth.type.Role
import java.time.LocalDateTime

class General(
    accountId: String,
    password: String,
    nickname: String,
    role: Role,
    createdBy: Long,
    createdAt: LocalDateTime
): User(
    accountId = accountId,
    password = password,
    nickname = nickname,
    role = role,
    createdBy = createdBy,
    createdAt = createdAt
) {
    fun editStatus(role: Role){
        this.roleList.add(role)
    }
}