package com.example.transactionmonitor.domain.model

enum class DeviceOnlineStatus {
    ONLINE, OFFLINE, CONNECTING, UNKNOWN
}

data class Device(
    val deviceId: String,
    val deviceName: String,
    val model: String,
    val onlineStatus: DeviceOnlineStatus,
    val simStatus: String,
    val serverConnection: String,
    val batteryLevel: Int,
    val lastSync: String,
    val lastTransaction: String
)
