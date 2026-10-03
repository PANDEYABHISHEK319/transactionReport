package com.example.transactionmonitor.data.repository

import com.example.transactionmonitor.domain.model.User
import com.example.transactionmonitor.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeAuthRepository : AuthRepository {
    private val _isLoggedIn = MutableStateFlow(false)
    override val isLoggedIn: Flow<Boolean> = _isLoggedIn.asStateFlow()

    private val mockUser = User(
        id = "USR-001",
        name = "Authorized Merchant",
        email = "merchant@transactionmonitor.com",
        mobile = "+91 9876543210"
    )

    override suspend fun login(emailOrMobile: String, password: String): Result<User> {
        delay(800)
        if (emailOrMobile.isNotBlank() && password.isNotBlank()) {
            _isLoggedIn.value = true
            return Result.success(mockUser)
        }
        return Result.failure(IllegalArgumentException("Invalid email or password"))
    }

    override suspend fun getCurrentUser(): User? {
        return if (_isLoggedIn.value) mockUser else null
    }

    override suspend fun logout() {
        _isLoggedIn.value = false
    }
}
