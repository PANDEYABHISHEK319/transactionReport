package com.example.transactionmonitor.data.mapper

import com.example.transactionmonitor.data.dto.DashboardSummaryDto
import com.example.transactionmonitor.domain.model.DashboardSummary

fun DashboardSummaryDto.toDomain(): DashboardSummary {
    return DashboardSummary(
        totalTransactions = totalTransactions,
        totalAmount = totalAmount,
        successfulTransactions = successfulTransactions,
        failedTransactions = failedTransactions,
        recentTransactions = recentTransactions.map { it.toDomain() }
    )
}
