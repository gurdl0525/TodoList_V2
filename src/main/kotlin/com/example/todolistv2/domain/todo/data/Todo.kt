package com.example.todolistv2.domain.todo.data

import com.example.todolistv2.domain.auth.data.entity.User
import com.example.todolistv2.global.base.entity.BaseAuthorEntity
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.Size


@Entity
class Todo(
    title: String,
    content: String,
    categoryList: MutableList<Category>,
    createdBy: Long,
    createdAt: LocalDateTime,
    user: User
): BaseAuthorEntity(
    createdBy = createdBy,
    createdAt = createdAt
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "title", nullable = false)
    @Size(min = 1, max = 10)
    var title: String = title
        protected set

    @Column(name = "content", nullable = false)
    @Size(min = 4, max = 15)
    var content: String = content
        protected set

    @OneToMany(mappedBy = "todo")
    var categoryList: MutableList<Category>? = categoryList
        protected set

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set
}