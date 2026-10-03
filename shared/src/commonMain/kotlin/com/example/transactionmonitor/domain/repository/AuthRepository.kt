package com.example.transactionmonitor.domain.repository

import com.example.transactionmonitor.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(emailOrMobile: String, password: String): Result<User>
    suspend fun getCurrentUser(): User?
    suspend fun logout()
    val isLoggedIn: Flow<Boolean>
}
