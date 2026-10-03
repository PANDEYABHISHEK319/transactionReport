package com.example.transactionmonitor.presentation.device

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionmonitor.domain.model.Device
import com.example.transactionmonitor.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface DeviceStatusUiState {
    data object Loading : DeviceStatusUiState
    data class Success(val devices: List<Device>) : DeviceStatusUiState
    data class Error(val message: String) : DeviceStatusUiState
}

class DeviceStatusViewModel(
    private val deviceRepository: DeviceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DeviceStatusUiState>(DeviceStatusUiState.Loading)
    val uiState: StateFlow<DeviceStatusUiState> = _uiState.asStateFlow()

    init {
        loadDevices()
    }

    fun loadDevices() {
        viewModelScope.launch {
            _uiState.value = DeviceStatusUiState.Loading
            val result = deviceRepository.getDevices()
            if (result.isSuccess) {
                _uiState.value = DeviceStatusUiState.Success(result.getOrThrow())
            } else {
                _uiState.value = DeviceStatusUiState.Error(
                    result.exceptionOrNull()?.message ?: "Failed to load device status"
                )
            }
        }
    }
}
