package com.example.transactionmonitor.data.repository

import com.example.transactionmonitor.domain.model.AppNotification
import com.example.transactionmonitor.domain.repository.NotificationRepository
import kotlinx.coroutines.delay

class FakeNotificationRepository : NotificationRepository {
    private val notifications = mutableListOf(
        AppNotification(
            id = "NOTIF-01",
            title = "Transaction Successful",
            message = "₹500 via NFC Transfer",
            type = "SUCCESS",
            timestamp = "10:45 AM",
            isRead = false
        ),
        AppNotification(
            id = "NOTIF-02",
            title = "Transaction Failed",
            message = "₹1,200 via UPI",
            type = "FAILED",
            timestamp = "08:15 AM",
            isRead = false
        ),
        AppNotification(
            id = "NOTIF-03",
            title = "Device Offline",
            message = "Device-A is offline",
            type = "WARNING",
            timestamp = "07:30 AM",
            isRead = true
        ),
        AppNotification(
            id = "NOTIF-04",
            title = "New Transaction",
            message = "₹250 via NFC Transfer",
            type = "INFO",
            timestamp = "06:50 AM",
            isRead = true
        ),
        AppNotification(
            id = "NOTIF-05",
            title = "Device Online",
            message = "Device-A is online",
            type = "SUCCESS",
            timestamp = "06:10 AM",
            isRead = true
        )
    )

    override suspend fun getNotifications(): Result<List<AppNotification>> {
        delay(400)
        return Result.success(notifications)
    }

    override suspend fun markAsRead(notificationId: String): Result<Unit> {
        delay(200)
        val index = notifications.indexOfFirst { it.id == notificationId }
        if (index != -1) {
            val n = notifications[index]
            notifications[index] = n.copy(isRead = true)
        }
        return Result.success(Unit)
    }
}
