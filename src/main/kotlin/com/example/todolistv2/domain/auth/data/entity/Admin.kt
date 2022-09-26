package com.example.todolistv2.domain.auth.data.entity

import com.example.todolistv2.domain.auth.data.entity.type.Role
import java.time.LocalDateTime
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("admin")
class Admin(
    accountId: String,
    password: String,
    nickname: String,
    createdAt: LocalDateTime
): User(
    accountId = accountId,
    password = password,
    nickname = nickname,
    role = Role.ADMIN,
    createdAt = createdAt
) {}