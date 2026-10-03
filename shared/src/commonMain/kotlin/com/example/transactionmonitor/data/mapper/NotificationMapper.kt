package com.example.transactionmonitor.data.mapper

import com.example.transactionmonitor.data.dto.NotificationDto
import com.example.transactionmonitor.domain.model.AppNotification

fun NotificationDto.toDomain(): AppNotification {
    return AppNotification(
        id = id,
        title = title,
        message = message,
        type = type,
        timestamp = timestamp,
        isRead = isRead
    )
}
