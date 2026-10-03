package com.example.transactionmonitor.domain.model

enum class TransactionStatus {
    SUCCESS, FAILED, PENDING
}

enum class TransactionType {
    NFC_TRANSFER,
    NFC_TOP_UP,
    STORE_PAYMENT,
    MONEY_TRANSFER,
    NFC_TRANSACTION,
    UPI_PAYMENT
}

enum class TransactionDirection {
    SENT,
    RECEIVED
}

data class Transaction(
    val id: String,
    val title: String,
    val amount: Double,
    val currency: String = "₹",
    val direction: TransactionDirection,
    val dateTime: String,
    val transactionType: TransactionType,
    val deviceId: String?,
    val nfcCardId: String?,
    val utrNumber: String?,
    val status: TransactionStatus,
    val balance: Double = 0.0
)
