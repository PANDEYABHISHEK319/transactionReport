package com.example.transactionmonitor.presentation.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionmonitor.domain.model.Transaction
import com.example.transactionmonitor.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface TransactionListUiState {
    data object Loading : TransactionListUiState
    data class Success(
        val transactions: List<Transaction>,
        val searchQuery: String = "",
        val selectedFilter: String = "ALL"
    ) : TransactionListUiState
    data class Error(val message: String) : TransactionListUiState
}

class TransactionListViewModel(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<TransactionListUiState>(TransactionListUiState.Loading)
    val uiState: StateFlow<TransactionListUiState> = _uiState.asStateFlow()

    private var allTransactions = listOf<Transaction>()
    private var currentQuery = ""
    private var currentFilter = "ALL"

    init {
        loadTransactions()
    }

    fun loadTransactions() {
        viewModelScope.launch {
            _uiState.value = TransactionListUiState.Loading
            val result = transactionRepository.getTransactions()
            if (result.isSuccess) {
                allTransactions = result.getOrThrow()
                applyFilterAndSearch()
            } else {
                _uiState.value = TransactionListUiState.Error(
                    result.exceptionOrNull()?.message ?: "Failed to load transactions"
                )
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        currentQuery = query
        applyFilterAndSearch()
    }

    fun onFilterChanged(filter: String) {
        currentFilter = filter
        applyFilterAndSearch()
    }

    private fun applyFilterAndSearch() {
        var filtered = allTransactions

        if (currentFilter.uppercase() != "ALL") {
            filtered = filtered.filter { it.status.name.uppercase() == currentFilter.uppercase() }
        }

        if (currentQuery.isNotBlank()) {
            val q = currentQuery.lowercase()
            filtered = filtered.filter {
                it.id.lowercase().contains(q) ||
                (it.utrNumber?.lowercase()?.contains(q) == true) ||
                it.amount.toString().contains(q) ||
                (it.deviceId?.lowercase()?.contains(q) == true) ||
                it.title.lowercase().contains(q) ||
                it.transactionType.name.lowercase().contains(q)
            }
        }

        _uiState.value = TransactionListUiState.Success(
            transactions = filtered,
            searchQuery = currentQuery,
            selectedFilter = currentFilter
        )
    }
}
