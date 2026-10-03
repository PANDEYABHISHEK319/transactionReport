package com.example.transactionmonitor.data.mapper

import com.example.transactionmonitor.data.dto.DeviceDto
import com.example.transactionmonitor.domain.model.Device
import com.example.transactionmonitor.domain.model.DeviceOnlineStatus

fun DeviceDto.toDomain(): Device {
    val status = when (onlineStatus.uppercase()) {
        "ONLINE" -> DeviceOnlineStatus.ONLINE
        "OFFLINE" -> DeviceOnlineStatus.OFFLINE
        "CONNECTING" -> DeviceOnlineStatus.CONNECTING
        else -> DeviceOnlineStatus.UNKNOWN
    }
    return Device(
        deviceId = deviceId,
        deviceName = deviceName,
        model = model,
        onlineStatus = status,
        simStatus = simStatus,
        serverConnection = serverConnection,
        batteryLevel = batteryLevel,
        lastSync = lastSync,
        lastTransaction = lastTransaction
    )
}
