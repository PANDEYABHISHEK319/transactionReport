package com.example.transactionmonitor.data.repository

import com.example.transactionmonitor.domain.model.Transaction
import com.example.transactionmonitor.domain.model.TransactionDirection
import com.example.transactionmonitor.domain.model.TransactionStatus
import com.example.transactionmonitor.domain.model.TransactionType
import com.example.transactionmonitor.domain.repository.TransactionRepository
import kotlinx.coroutines.delay

class FakeTransactionRepository : TransactionRepository {
    private val transactions = mutableListOf(
        Transaction(
            id = "TXN001",
            title = "Sent to NFC",
            amount = 200.0,
            currency = "₹",
            direction = TransactionDirection.SENT,
            dateTime = "02 Oct 2026, 10:30 AM",
            transactionType = TransactionType.NFC_TRANSFER,
            deviceId = "DEV-001",
            nfcCardId = "NFC-9876",
            utrNumber = "UTR001234567",
            status = TransactionStatus.SUCCESS,
            balance = 4850.0
        ),
        Transaction(
            id = "TXN002",
            title = "Received from NFC",
            amount = 500.0,
            currency = "₹",
            direction = TransactionDirection.RECEIVED,
            dateTime = "01 Oct 2026, 08:12 PM",
            transactionType = TransactionType.NFC_TRANSFER,
            deviceId = "DEV-001",
            nfcCardId = "NFC-8765",
            utrNumber = "UTR001234568",
            status = TransactionStatus.SUCCESS,
            balance = 5050.0
        ),
        Transaction(
            id = "TXN003",
            title = "Paid at Store",
            amount = 150.0,
            currency = "₹",
            direction = TransactionDirection.SENT,
            dateTime = "30 Sep 2026, 04:45 PM",
            transactionType = TransactionType.STORE_PAYMENT,
            deviceId = "DEV-001",
            nfcCardId = "NFC-7654",
            utrNumber = "UTR001234569",
            status = TransactionStatus.SUCCESS,
            balance = 4550.0
        ),
        Transaction(
            id = "TXN004",
            title = "NFC Top-up",
            amount = 1000.0,
            currency = "₹",
            direction = TransactionDirection.RECEIVED,
            dateTime = "29 Sep 2026, 11:20 AM",
            transactionType = TransactionType.NFC_TOP_UP,
            deviceId = "DEV-001",
            nfcCardId = "NFC-5432",
            utrNumber = "UTR001234570",
            status = TransactionStatus.SUCCESS,
            balance = 4700.0
        )
    )

    override suspend fun getTransactions(): Result<List<Transaction>> {
        delay(400)
        return Result.success(transactions)
    }

    override suspend fun getTransactionById(transactionId: String): Result<Transaction?> {
        delay(200)
        return Result.success(transactions.find { it.id == transactionId })
    }

    override suspend fun searchTransactions(query: String): List<Transaction> {
        if (query.isBlank()) return transactions
        val lower = query.lowercase()
        return transactions.filter {
            it.id.lowercase().contains(lower) ||
            it.title.lowercase().contains(lower) ||
            it.utrNumber?.lowercase()?.contains(lower) == true ||
            it.amount.toString().contains(lower)
        }
    }

    override suspend fun filterTransactions(status: String?): List<Transaction> {
        if (status.isNullOrBlank() || status.uppercase() == "ALL") return transactions
        return transactions.filter { it.status.name.uppercase() == status.uppercase() }
    }
}
