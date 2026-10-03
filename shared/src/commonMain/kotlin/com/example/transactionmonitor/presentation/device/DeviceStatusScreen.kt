package com.example.transactionmonitor.presentation.device

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.transactionmonitor.data.repository.FakeDeviceRepository
import com.example.transactionmonitor.domain.model.Device
import com.example.transactionmonitor.domain.model.DeviceOnlineStatus
import com.example.transactionmonitor.domain.repository.DeviceRepository
import com.example.transactionmonitor.presentation.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceStatusScreen(
    onNavigateBack: () -> Unit,
    deviceRepository: DeviceRepository = remember { FakeDeviceRepository() }
) {
    val viewModel = remember { DeviceStatusViewModel(deviceRepository) }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Device Status") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = AppVectorIcons.Back,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (val state = uiState) {
                is DeviceStatusUiState.Loading -> {
                    LoadingState()
                }
                is DeviceStatusUiState.Error -> {
                    ErrorState(message = state.message, onRetry = { viewModel.loadDevices() })
                }
                is DeviceStatusUiState.Success -> {
                    val devices = state.devices
                    if (devices.isEmpty()) {
                        EmptyState(message = "No prototype devices registered")
                    } else {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            devices.forEach { device ->
                                DeviceCard(device = device)
                            }
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DeviceCard(device: Device) {
    val statusColor = when (device.onlineStatus) {
        DeviceOnlineStatus.ONLINE -> Color(0xFF2E7D32)
        DeviceOnlineStatus.OFFLINE -> Color(0xFFC62828)
        DeviceOnlineStatus.CONNECTING -> Color(0xFFEF6C00)
        DeviceOnlineStatus.UNKNOWN -> Color.Gray
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = device.deviceName,
                    style = MaterialTheme.typography.titleLarge
                )
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = statusColor.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = device.onlineStatus.name,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = statusColor
                    )
                }
            }

            Text(
                text = "Last Sync: ${device.lastSync}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            DetailRow("Device ID", device.deviceId)
            DetailRow("Model", device.model)
            DetailRow("SIM Status", device.simStatus)
            DetailRow("Server Connection", device.serverConnection)
            DetailRow("Battery Level", "${device.batteryLevel}%")
            DetailRow("Last Transaction", device.lastTransaction)
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
