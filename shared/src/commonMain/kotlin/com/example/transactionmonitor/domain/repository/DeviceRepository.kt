package com.example.transactionmonitor.domain.repository

import com.example.transactionmonitor.domain.model.Device

interface DeviceRepository {
    suspend fun getDevices(): Result<List<Device>>
    suspend fun getDeviceById(deviceId: String): Result<Device?>
}
