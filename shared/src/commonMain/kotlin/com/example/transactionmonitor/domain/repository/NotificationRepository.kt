package com.example.transactionmonitor.domain.repository

import com.example.transactionmonitor.domain.model.AppNotification

interface NotificationRepository {
    suspend fun getNotifications(): Result<List<AppNotification>>
    suspend fun markAsRead(notificationId: String): Result<Unit>
}
