package com.example.todolistv2.domain.auth.data

import com.example.todolistv2.domain.auth.type.Role

class Admin(
    accountId: String,
    password: String,
    nickname: String
): User(
    accountId = accountId,
    password = password,
    nickname = nickname,
    role = Role.ADMIN
) {}