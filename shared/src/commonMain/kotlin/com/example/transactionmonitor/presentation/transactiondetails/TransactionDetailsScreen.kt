package com.example.transactionmonitor.presentation.transactiondetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.transactionmonitor.data.repository.FakeTransactionRepository
import com.example.transactionmonitor.domain.model.TransactionStatus
import com.example.transactionmonitor.domain.repository.TransactionRepository
import com.example.transactionmonitor.presentation.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionDetailsScreen(
    transactionId: String,
    onNavigateBack: () -> Unit,
    transactionRepository: TransactionRepository = remember { FakeTransactionRepository() }
) {
    val viewModel = remember(transactionId) { TransactionDetailsViewModel(transactionId, transactionRepository) }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transaction Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Text("←", style = MaterialTheme.typography.titleLarge)
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
                is TransactionDetailsUiState.Loading -> {
                    LoadingState()
                }
                is TransactionDetailsUiState.Error -> {
                    ErrorState(message = state.message, onRetry = { viewModel.loadTransaction() })
                }
                is TransactionDetailsUiState.Success -> {
                    val txn = state.transaction
                    val statusColor = when (txn.status) {
                        TransactionStatus.SUCCESS -> Color(0xFF2E7D32)
                        TransactionStatus.FAILED -> Color(0xFFC62828)
                        TransactionStatus.PENDING -> Color(0xFFEF6C00)
                    }
                    val statusSymbol = when (txn.status) {
                        TransactionStatus.SUCCESS -> "✓"
                        TransactionStatus.FAILED -> "✕"
                        TransactionStatus.PENDING -> "⏱"
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Surface(
                            modifier = Modifier.size(72.dp),
                            shape = MaterialTheme.shapes.extraLarge,
                            color = statusColor.copy(alpha = 0.15f)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = statusSymbol,
                                    style = MaterialTheme.typography.headlineLarge,
                                    color = statusColor
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "${txn.currency}${txn.amount}",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = txn.status.name,
                            style = MaterialTheme.typography.bodyLarge,
                            color = statusColor
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = txn.title,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                DetailRow("Transaction ID", txn.id)
                                DetailRow("Title", txn.title)
                                DetailRow("Date & Time", txn.dateTime)
                                DetailRow("Transaction Type", txn.transactionType.name.replace("_", " "))
                                DetailRow("Status", txn.status.name)
                                DetailRow("Device ID", txn.deviceId ?: "-")
                                DetailRow("NFC Card ID", txn.nfcCardId ?: "-")
                                DetailRow("UTR / Reference", txn.utrNumber ?: "-")
                                DetailRow("Amount", "${txn.currency}${txn.amount}")
                                DetailRow("Balance", "${txn.currency}${txn.balance}")
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            OutlinedButton(
                                onClick = { /* Copy ID */ },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Copy ID")
                            }
                            OutlinedButton(
                                onClick = { /* Copy UTR */ },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Copy UTR")
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        PrimaryButton(
                            text = "Share Receipt",
                            onClick = { /* Share receipt */ }
                        )

                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
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
