package com.example.todolistv2.global.error.exception

import com.example.todolistv2.global.error.data.ErrorCode
import java.lang.RuntimeException

open class GlobalException(
    val errorCode: ErrorCode,
    val data: String
): RuntimeException(errorCode.message) {
}