package com.example.transactionmonitor.presentation.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionmonitor.domain.model.AppNotification
import com.example.transactionmonitor.domain.repository.NotificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface NotificationUiState {
    data object Loading : NotificationUiState
    data class Success(val notifications: List<AppNotification>) : NotificationUiState
    data class Error(val message: String) : NotificationUiState
}

class NotificationViewModel(
    private val notificationRepository: NotificationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<NotificationUiState>(NotificationUiState.Loading)
    val uiState: StateFlow<NotificationUiState> = _uiState.asStateFlow()

    init {
        loadNotifications()
    }

    fun loadNotifications() {
        viewModelScope.launch {
            _uiState.value = NotificationUiState.Loading
            val result = notificationRepository.getNotifications()
            if (result.isSuccess) {
                _uiState.value = NotificationUiState.Success(result.getOrThrow())
            } else {
                _uiState.value = NotificationUiState.Error(
                    result.exceptionOrNull()?.message ?: "Failed to load notifications"
                )
            }
        }
    }

    fun markAsRead(notificationId: String) {
        viewModelScope.launch {
            notificationRepository.markAsRead(notificationId)
            loadNotifications()
        }
    }
}
