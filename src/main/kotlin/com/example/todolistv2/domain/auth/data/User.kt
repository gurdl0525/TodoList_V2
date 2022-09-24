package com.example.todolistv2.domain.auth.data

import com.example.todolistv2.domain.auth.type.Role
import com.example.todolistv2.global.base.entity.BaseAuthorEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user")
abstract class User(
    accountId: String,
    password: String,
    nickname: String,
    role: Role,
    createdBy: Long,
    createdAt: LocalDateTime
): BaseAuthorEntity(
    createdBy = createdBy,
    createdAt = createdAt
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "account_id")
    var accountId = accountId
        protected set

    @Column(name = "password")
    var password = password
        protected set

    @Column(name = "nickname")
    var nickname = nickname
        protected set

    @ElementCollection
    var roleList: MutableList<Role> = ArrayList()
        protected set

    init {
        this.roleList.add(role)
    }

    fun updated(id: Long, time: LocalDateTime){
        this.updatedBy = id
        this.updatedAt = time
    }
}