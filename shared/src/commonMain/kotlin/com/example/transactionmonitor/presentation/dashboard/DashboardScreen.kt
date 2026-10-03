package com.example.transactionmonitor.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.transactionmonitor.data.repository.FakeDashboardRepository
import com.example.transactionmonitor.domain.repository.DashboardRepository
import com.example.transactionmonitor.presentation.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigateToTransactions: () -> Unit,
    onNavigateToTransactionDetails: (String) -> Unit,
    onNavigateToNotifications: () -> Unit,
    onMenuClick: () -> Unit,
    dashboardRepository: DashboardRepository = remember { FakeDashboardRepository() }
) {
    val viewModel = remember { DashboardViewModel(dashboardRepository) }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                navigationIcon = {
                    IconButton(onClick = onMenuClick) {
                        Text("☰", style = MaterialTheme.typography.titleMedium)
                    }
                },
                actions = {
                    IconButton(onClick = onNavigateToNotifications) {
                        Text("🔔", style = MaterialTheme.typography.titleMedium)
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
                is DashboardUiState.Loading -> {
                    LoadingState()
                }
                is DashboardUiState.Error -> {
                    ErrorState(message = state.message, onRetry = { viewModel.loadDashboardSummary() })
                }
                is DashboardUiState.Success -> {
                    val summary = state.summary
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedButton(onClick = { /* Date filter popup */ }) {
                                    Text("📅 Today ▼")
                                }
                            }
                        }

                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    SummaryCard(
                                        title = "Transactions",
                                        value = summary.totalTransactions.toString(),
                                        modifier = Modifier.weight(1f)
                                    )
                                    SummaryCard(
                                        title = "Total Amount",
                                        value = "₹${summary.totalAmount.toInt()}",
                                        modifier = Modifier.weight(1f),
                                        valueColor = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    SummaryCard(
                                        title = "Success",
                                        value = summary.successfulTransactions.toString(),
                                        modifier = Modifier.weight(1f),
                                        valueColor = Color(0xFF2E7D32)
                                    )
                                    SummaryCard(
                                        title = "Failed",
                                        value = summary.failedTransactions.toString(),
                                        modifier = Modifier.weight(1f),
                                        valueColor = Color(0xFFC62828)
                                    )
                                }
                            }
                        }

                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Recent Transactions",
                                    style = MaterialTheme.typography.titleMedium
                                )
                                TextButton(onClick = onNavigateToTransactions) {
                                    Text("View All")
                                }
                            }
                        }

                        if (summary.recentTransactions.isEmpty()) {
                            item {
                                EmptyState(message = "No recent transactions")
                            }
                        } else {
                            items(summary.recentTransactions) { transaction ->
                                TransactionCard(
                                    transaction = transaction,
                                    onClick = { onNavigateToTransactionDetails(transaction.id) }
                                )
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }
            }
        }
    }
}
