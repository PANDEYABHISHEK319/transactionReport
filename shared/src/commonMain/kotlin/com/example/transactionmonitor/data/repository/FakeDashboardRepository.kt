package com.example.transactionmonitor.data.repository

import com.example.transactionmonitor.domain.model.DashboardSummary
import com.example.transactionmonitor.domain.model.TransactionStatus
import com.example.transactionmonitor.domain.repository.DashboardRepository
import com.example.transactionmonitor.domain.repository.TransactionRepository
import kotlinx.coroutines.delay

class FakeDashboardRepository(
    private val transactionRepository: TransactionRepository = FakeTransactionRepository()
) : DashboardRepository {
    override suspend fun getDashboardSummary(): Result<DashboardSummary> {
        delay(500)
        val txnsResult = transactionRepository.getTransactions()
        val txns = txnsResult.getOrDefault(emptyList())
        val totalAmount = txns.filter { it.status == TransactionStatus.SUCCESS }.sumOf { it.amount }
        val successful = txns.count { it.status == TransactionStatus.SUCCESS }
        val failed = txns.count { it.status == TransactionStatus.FAILED }

        return Result.success(
            DashboardSummary(
                totalTransactions = txns.size,
                totalAmount = totalAmount,
                successfulTransactions = successful,
                failedTransactions = failed,
                recentTransactions = txns.take(3)
            )
        )
    }
}
