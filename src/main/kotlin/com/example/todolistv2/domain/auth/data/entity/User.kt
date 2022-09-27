package com.example.todolistv2.domain.auth.data.entity

import com.example.todolistv2.domain.auth.data.entity.type.Role
import com.example.todolistv2.global.base.entity.BaseTimeEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user")
@DiscriminatorColumn(name = "user_type")
abstract class User(
    accountId: String,
    password: String,
    nickname: String,
    role: Role,
    createdAt: LocalDateTime
): BaseTimeEntity(
    createdAt = createdAt
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "account_id", nullable = false)
    var accountId = accountId
        protected set

    @Column(name = "password", nullable = false)
    var password = password
        protected set

    @Column(name = "nickname", nullable = false)
    var nickname = nickname
        protected set

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    var role: Role = role
        protected set

    fun updated(time: LocalDateTime){
        this.updatedAt = time
    }

    fun editNickname(nickname: String){
        this.nickname = nickname
    }
}