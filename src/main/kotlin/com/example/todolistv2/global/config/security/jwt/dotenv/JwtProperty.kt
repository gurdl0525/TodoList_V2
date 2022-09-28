package com.example.todolistv2.global.config.security.jwt.dotenv

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(value = "jwt")
@ConstructorBinding
data class JwtProperty(
    val header: String,
    val secretKey: String,
    val accessExpiredAt: Long,
    val accessClaim: String,
    val refreshExpiredAt: Long,
    val refreshClaim: String
)
