package com.example.todolistv2.global.base.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity(
    createdAt: LocalDateTime
) {

    @CreatedDate
    @Column(name = "created_at")
    open var createdAt: LocalDateTime = createdAt
        protected set

    @LastModifiedDate
    @Column(name = "update_at")
    open var updatedAt: LocalDateTime? = null
        protected set

}