package com.example.transactionmonitor.data.repository

import com.example.transactionmonitor.domain.model.Device
import com.example.transactionmonitor.domain.model.DeviceOnlineStatus
import com.example.transactionmonitor.domain.repository.DeviceRepository
import kotlinx.coroutines.delay

class FakeDeviceRepository : DeviceRepository {
    private val devices = listOf(
        Device(
            deviceId = "A001",
            deviceName = "Device - A",
            model = "Prototype V1",
            onlineStatus = DeviceOnlineStatus.ONLINE,
            simStatus = "Connected (4G)",
            serverConnection = "Online",
            batteryLevel = 85,
            lastSync = "01 Oct 2026, 10:45 AM",
            lastTransaction = "01 Oct 2026, 10:45 AM"
        )
    )

    override suspend fun getDevices(): Result<List<Device>> {
        delay(400)
        return Result.success(devices)
    }

    override suspend fun getDeviceById(deviceId: String): Result<Device?> {
        delay(200)
        return Result.success(devices.find { it.deviceId == deviceId })
    }
}
