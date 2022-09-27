package com.example.todolistv2.domain.auth.data.entity

import com.example.todolistv2.domain.auth.data.entity.type.Role
import com.example.todolistv2.domain.todo.data.Todo
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.OneToMany

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
    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE])
    var todoList: MutableList<Todo>? = null
        protected set

    fun addTodoList(todo: Todo){
        this.todoList!!.add(todo)
    }
}