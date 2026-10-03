package com.example.transactionmonitor.domain.model

data class AppNotification(
    val id: String,
    val title: String,
    val message: String,
    val type: String,
    val timestamp: String,
    val isRead: Boolean
)
