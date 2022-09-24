package com.example.todolistv2.global.base.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseAuthorEntity(
    createdBy: Long,
    createdAt: LocalDateTime
):BaseTimeEntity(
    createdAt = createdAt
) {

    @CreatedBy
    open var createdBy: Long = createdBy
        protected set

    @LastModifiedBy
    open var updatedBy: Long? = null
        protected set

}
