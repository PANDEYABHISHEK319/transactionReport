package com.example.transactionmonitor

import androidx.compose.runtime.*
import com.example.transactionmonitor.data.repository.FakeAuthRepository
import com.example.transactionmonitor.presentation.actions.*
import com.example.transactionmonitor.presentation.dashboard.DashboardScreen
import com.example.transactionmonitor.presentation.device.DeviceStatusScreen
import com.example.transactionmonitor.presentation.login.LoginScreen
import com.example.transactionmonitor.presentation.navigation.Screen
import com.example.transactionmonitor.presentation.notifications.NotificationScreen
import com.example.transactionmonitor.presentation.profile.ProfileScreen
import com.example.transactionmonitor.presentation.splash.SplashScreen
import com.example.transactionmonitor.presentation.theme.TransactionMonitorTheme
import com.example.transactionmonitor.presentation.transactiondetails.TransactionDetailsScreen
import com.example.transactionmonitor.presentation.transactions.TransactionListScreen

@Composable
fun App() {
    TransactionMonitorTheme {
        val backstack = remember { mutableStateListOf<Screen>(Screen.Splash) }
        val authRepository = remember { FakeAuthRepository() }
        var selectedTransactionId by remember { mutableStateOf<String?>(null) }

        val currentScreen = backstack.lastOrNull() ?: Screen.Splash

        when (currentScreen) {
            is Screen.Splash -> {
                SplashScreen(
                    onNavigateToLogin = {
                        backstack.clear()
                        backstack.add(Screen.Login)
                    },
                    onNavigateToDashboard = {
                        backstack.clear()
                        backstack.add(Screen.Dashboard)
                    },
                    authRepository = authRepository
                )
            }
            is Screen.Login -> {
                LoginScreen(
                    onLoginSuccess = {
                        backstack.clear()
                        backstack.add(Screen.Dashboard)
                    },
                    authRepository = authRepository
                )
            }
            is Screen.Dashboard -> {
                DashboardScreen(
                    onNavigateToScan = {
                        backstack.add(Screen.Scan)
                    },
                    onNavigateToTransactions = {
                        backstack.add(Screen.Transactions)
                    },
                    onNavigateToSendToNfc = {
                        backstack.add(Screen.SendToNfc)
                    },
                    onNavigateToSendMoney = {
                        backstack.add(Screen.SendMoney)
                    },
                    onNavigateToRequestMoney = {
                        backstack.add(Screen.RequestMoney)
                    },
                    onNavigateToBalance = {
                        backstack.add(Screen.Balance)
                    },
                    onNavigateToNotifications = {
                        backstack.add(Screen.Notifications)
                    },
                    onMenuClick = {
                        backstack.add(Screen.Profile)
                    }
                )
            }
            is Screen.Transactions -> {
                TransactionListScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    },
                    onNavigateToDetails = { txnId ->
                        selectedTransactionId = txnId
                        backstack.add(Screen.TransactionDetails)
                    }
                )
            }
            is Screen.TransactionDetails -> {
                TransactionDetailsScreen(
                    transactionId = selectedTransactionId ?: "",
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.Scan -> {
                ScanScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.SendToNfc -> {
                SendToNfcScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.SendMoney -> {
                SendMoneyScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.RequestMoney -> {
                RequestMoneyScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.Balance -> {
                BalanceScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.DeviceStatus -> {
                DeviceStatusScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.Notifications -> {
                NotificationScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    }
                )
            }
            is Screen.Profile -> {
                ProfileScreen(
                    onNavigateBack = {
                        if (backstack.size > 1) backstack.removeAt(backstack.size - 1)
                    },
                    onNavigateToDevices = {
                        backstack.add(Screen.DeviceStatus)
                    },
                    onNavigateToNotifications = {
                        backstack.add(Screen.Notifications)
                    },
                    onLogout = {
                        backstack.clear()
                        backstack.add(Screen.Login)
                    }
                )
            }
        }
    }
}
