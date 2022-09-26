package com.example.todolistv2.global.error.exception.common

import com.example.todolistv2.global.error.data.ErrorCode
import com.example.todolistv2.global.error.exception.GlobalException

class UnAuthorizedException(data: String): GlobalException(ErrorCode.UN_AUTHORIZED, data) {
}