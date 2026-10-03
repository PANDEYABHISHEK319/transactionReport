package com.example.transactionmonitor.domain.model

data class DashboardSummary(
    val totalTransactions: Int,
    val totalAmount: Double,
    val successfulTransactions: Int,
    val failedTransactions: Int,
    val recentTransactions: List<Transaction>
)
