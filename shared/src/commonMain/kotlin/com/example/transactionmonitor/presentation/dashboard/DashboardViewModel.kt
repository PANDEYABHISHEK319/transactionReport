package com.example.transactionmonitor.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionmonitor.domain.model.DashboardSummary
import com.example.transactionmonitor.domain.repository.DashboardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface DashboardUiState {
    data object Loading : DashboardUiState
    data class Success(val summary: DashboardSummary) : DashboardUiState
    data class Error(val message: String) : DashboardUiState
}

class DashboardViewModel(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        loadDashboardSummary()
    }

    fun loadDashboardSummary() {
        viewModelScope.launch {
            _uiState.value = DashboardUiState.Loading
            val result = dashboardRepository.getDashboardSummary()
            if (result.isSuccess) {
                _uiState.value = DashboardUiState.Success(result.getOrThrow())
            } else {
                _uiState.value = DashboardUiState.Error(result.exceptionOrNull()?.message ?: "Failed to load dashboard summary")
            }
        }
    }
}
