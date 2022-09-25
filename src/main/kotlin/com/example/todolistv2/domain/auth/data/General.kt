package com.example.todolistv2.domain.auth.data

import com.example.todolistv2.domain.auth.type.Role
import java.time.LocalDateTime
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("general")
class General(
    accountId: String,
    password: String,
    nickname: String,
    role: Role,
    createdAt: LocalDateTime
): User(
    accountId = accountId,
    password = password,
    nickname = nickname,
    role = role,
    createdAt = createdAt
) {
}