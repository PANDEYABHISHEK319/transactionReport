package com.example.transactionmonitor.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionmonitor.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface LoginUiState {
    data object Initial : LoginUiState
    data object Loading : LoginUiState
    data object Success : LoginUiState
    data class Error(val message: String) : LoginUiState
}

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    var emailOrMobile: String = ""
    var password: String = ""
    var rememberMe: Boolean = false

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(onSuccess: () -> Unit) {
        if (emailOrMobile.isBlank() || password.isBlank()) {
            _uiState.value = LoginUiState.Error("Please enter email/mobile and password")
            return
        }

        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading
            val result = authRepository.login(emailOrMobile, password)
            if (result.isSuccess) {
                _uiState.value = LoginUiState.Success
                onSuccess()
            } else {
                _uiState.value = LoginUiState.Error(result.exceptionOrNull()?.message ?: "Login failed")
            }
        }
    }
}
