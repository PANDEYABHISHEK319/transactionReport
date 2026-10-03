package com.example.transactionmonitor.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DeviceDto(
    val deviceId: String,
    val deviceName: String,
    val model: String,
    val onlineStatus: String,
    val simStatus: String,
    val serverConnection: String,
    val batteryLevel: Int,
    val lastSync: String,
    val lastTransaction: String
)
