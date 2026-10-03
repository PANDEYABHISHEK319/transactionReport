package com.example.transactionmonitor.domain.repository

import com.example.transactionmonitor.domain.model.Transaction

interface TransactionRepository {
    suspend fun getTransactions(): Result<List<Transaction>>
    suspend fun getTransactionById(transactionId: String): Result<Transaction?>
    suspend fun searchTransactions(query: String): List<Transaction>
    suspend fun filterTransactions(status: String?): List<Transaction>
}
