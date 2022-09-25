package com.example.todolistv2.domain.todo.data

import com.example.todolistv2.domain.todo.type.CategoryType
import javax.persistence.*

@Entity
@Table(name = "category")
class Category(
    todo: Todo,
    categoryType: CategoryType
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "todo_id")
    var todo: Todo = todo
        protected set

    @Column(name = "category", nullable = false)
    var type: CategoryType = categoryType
        protected set
}