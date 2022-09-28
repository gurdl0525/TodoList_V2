package com.example.todolistv2.domain.auth.exception

import com.example.todolistv2.global.error.data.ErrorCode
import com.example.todolistv2.global.error.exception.GlobalException

class DuplicateNicknameException(data: String): GlobalException(ErrorCode.DUPLICATE_NICKNAME, data) {
}