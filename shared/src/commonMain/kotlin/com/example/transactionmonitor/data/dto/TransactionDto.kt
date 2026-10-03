package com.example.transactionmonitor.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto(
    val id: String,
    val title: String,
    val amount: Double,
    val currency: String = "₹",
    val direction: String,
    val dateTime: String,
    val transactionType: String,
    val deviceId: String? = null,
    val nfcCardId: String? = null,
    val utrNumber: String? = null,
    val status: String,
    val balance: Double = 0.0
)
