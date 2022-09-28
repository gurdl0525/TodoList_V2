package com.example.todolistv2.global.config.security.jwt

import com.example.todolistv2.global.config.security.jwt.auth.AuthDetailsService
import com.example.todolistv2.global.config.security.jwt.dotenv.JwtProperty
import com.example.todolistv2.global.error.exception.common.UnAuthorizedException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class TokenProvider(
    private val property: JwtProperty,
    private val authDetailsService: AuthDetailsService
) {

    fun generateAccessToken(accountId: String): String{
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, property.secretKey)
            .setHeaderParam("header", property.header)
            .claim("type", property.accessClaim)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + (property.accessExpiredAt * 1000)))
            .compact()
    }

    fun generateRefreshToken(accountId: String): String{
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, property.secretKey)
            .setHeaderParam("header", property.header)
            .claim("type", property.refreshClaim)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + (property.refreshExpiredAt * 1000)))
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(property.header)
            ?: return null
        return if (bearerToken.length > 7) { bearerToken.substring(7) }
        else { throw UnAuthorizedException(request.toString()) }
    }

    fun validatedToken(token: String): Boolean{
        try {
            return getTokenBody(token).expiration
                .after(Date())
        }catch (e: Exception){
            throw UnAuthorizedException(token)
        }
    }

    fun authentication(token: String): Authentication? {
        val authDetails = authDetailsService.loadUserByUsername(getUserId(token))
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    fun getUserId(token: String): String {
        return try {
            getTokenBody(token).subject
        } catch (e: java.lang.Exception) {
            throw UnAuthorizedException(token.toString())
        }
    }

    fun getTokenBody(token: String): Claims{
        return Jwts.parser()
            .setSigningKey(property.secretKey).parseClaimsJws(token).body;
    }

}