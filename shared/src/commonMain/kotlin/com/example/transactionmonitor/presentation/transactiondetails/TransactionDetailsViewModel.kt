package com.example.transactionmonitor.presentation.transactiondetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionmonitor.domain.model.Transaction
import com.example.transactionmonitor.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface TransactionDetailsUiState {
    data object Loading : TransactionDetailsUiState
    data class Success(val transaction: Transaction) : TransactionDetailsUiState
    data class Error(val message: String) : TransactionDetailsUiState
}

class TransactionDetailsViewModel(
    private val transactionId: String,
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<TransactionDetailsUiState>(TransactionDetailsUiState.Loading)
    val uiState: StateFlow<TransactionDetailsUiState> = _uiState.asStateFlow()

    init {
        loadTransaction()
    }

    fun loadTransaction() {
        viewModelScope.launch {
            _uiState.value = TransactionDetailsUiState.Loading
            val result = transactionRepository.getTransactionById(transactionId)
            if (result.isSuccess) {
                val txn = result.getOrThrow()
                if (txn != null) {
                    _uiState.value = TransactionDetailsUiState.Success(txn)
                } else {
                    _uiState.value = TransactionDetailsUiState.Error("Transaction not found")
                }
            } else {
                _uiState.value = TransactionDetailsUiState.Error(
                    result.exceptionOrNull()?.message ?: "Failed to load transaction details"
                )
            }
        }
    }
}
