package com.example.transactionmonitor.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DashboardSummaryDto(
    val totalTransactions: Int,
    val totalAmount: Double,
    val successfulTransactions: Int,
    val failedTransactions: Int,
    val recentTransactions: List<TransactionDto>
)
