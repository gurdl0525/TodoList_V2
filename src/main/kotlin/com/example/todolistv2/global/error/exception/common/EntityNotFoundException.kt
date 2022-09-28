package com.example.todolistv2.global.error.exception.common

import com.example.todolistv2.global.error.data.ErrorCode
import com.example.todolistv2.global.error.exception.GlobalException

class EntityNotFoundException(data: String): GlobalException(ErrorCode.ENTITY_NOT_FOUND, data) {
}