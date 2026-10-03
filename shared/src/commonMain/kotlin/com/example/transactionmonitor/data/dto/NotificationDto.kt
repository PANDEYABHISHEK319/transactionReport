package com.example.transactionmonitor.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class NotificationDto(
    val id: String,
    val title: String,
    val message: String,
    val type: String,
    val timestamp: String,
    val isRead: Boolean
)
