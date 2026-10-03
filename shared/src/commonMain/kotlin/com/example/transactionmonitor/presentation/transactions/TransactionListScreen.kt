package com.example.transactionmonitor.presentation.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.transactionmonitor.data.repository.FakeTransactionRepository
import com.example.transactionmonitor.domain.model.Transaction
import com.example.transactionmonitor.domain.model.TransactionDirection
import com.example.transactionmonitor.domain.repository.TransactionRepository
import com.example.transactionmonitor.presentation.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionListScreen(
    onNavigateBack: () -> Unit,
    onNavigateToDetails: (String) -> Unit,
    transactionRepository: TransactionRepository = remember { FakeTransactionRepository() }
) {
    val viewModel = remember { TransactionListViewModel(transactionRepository) }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recent Transactions") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = AppVectorIcons.Back,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    TextButton(onClick = { /* View All action */ }) {
                        Text(
                            text = "View All >",
                            color = Color(0xFF1976D2),
                            style = MaterialTheme.typography.bodyMedium
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
                .background(Color.White)
        ) {
            when (val state = uiState) {
                is TransactionListUiState.Loading -> {
                    LoadingState()
                }
                is TransactionListUiState.Error -> {
                    ErrorState(message = state.message, onRetry = { viewModel.loadTransactions() })
                }
                is TransactionListUiState.Success -> {
                    if (state.transactions.isEmpty()) {
                        EmptyState(message = "No transactions found")
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(state.transactions) { transaction ->
                                TransactionRowItem(
                                    transaction = transaction,
                                    onClick = { onNavigateToDetails(transaction.id) }
                                )
                                HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
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
}

@Composable
fun TransactionRowItem(
    transaction: Transaction,
    onClick: () -> Unit
) {
    val isIncoming = transaction.direction == TransactionDirection.RECEIVED
    val amountColor = if (isIncoming) Color(0xFF2E7D32) else Color(0xFFC62828)
    val amountPrefix = if (isIncoming) "+ " else "- "

    val iconVector: ImageVector = when (transaction.title) {
        "Sent to NFC" -> AppVectorIcons.SendTransaction
        "Received from NFC" -> AppVectorIcons.ReceiveTransaction
        "Paid at Store" -> AppVectorIcons.StorePayment
        "NFC Top-up" -> AppVectorIcons.NfcTopUp
        else -> AppVectorIcons.Wallet
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = Color(0xFFF1F5F9)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = transaction.title,
                        tint = Color(0xFF1976D2),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Column {
                Text(
                    text = transaction.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF1E293B)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = transaction.dateTime,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF64748B)
                )
            }
        }

        Text(
            text = "$amountPrefix${transaction.currency}${transaction.amount.toInt()}",
            style = MaterialTheme.typography.titleMedium,
            color = amountColor
        )
    }
}
