package com.example.transactionmonitor.presentation.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.transactionmonitor.data.repository.FakeAuthRepository
import com.example.transactionmonitor.presentation.dashboard.DashboardScreen
import com.example.transactionmonitor.presentation.device.DeviceStatusScreen
import com.example.transactionmonitor.presentation.login.LoginScreen
import com.example.transactionmonitor.presentation.notifications.NotificationScreen
import com.example.transactionmonitor.presentation.profile.ProfileScreen
import com.example.transactionmonitor.presentation.splash.SplashScreen
import com.example.transactionmonitor.presentation.transactiondetails.TransactionDetailsScreen
import com.example.transactionmonitor.presentation.transactions.TransactionListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val authRepository = remember { FakeAuthRepository() }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                onNavigateToDashboard = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                authRepository = authRepository
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                authRepository = authRepository
            )
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                onNavigateToTransactions = {
                    navController.navigate(Screen.Transactions.route)
                },
                onNavigateToTransactionDetails = { txnId ->
                    navController.navigate(Screen.TransactionDetails.createRoute(txnId))
                },
                onNavigateToNotifications = {
                    navController.navigate(Screen.Notifications.route)
                },
                onMenuClick = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }
        composable(Screen.Transactions.route) {
            TransactionListScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetails = { txnId ->
                    navController.navigate(Screen.TransactionDetails.createRoute(txnId))
                }
            )
        }
        composable(Screen.TransactionDetails.route) { backStackEntry ->
            val txnId = backStackEntry.arguments?.getString("transactionId") ?: ""
            TransactionDetailsScreen(
                transactionId = txnId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.DeviceStatus.route) {
            DeviceStatusScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Notifications.route) {
            NotificationScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDevices = {
                    navController.navigate(Screen.DeviceStatus.route)
                },
                onNavigateToNotifications = {
                    navController.navigate(Screen.Notifications.route)
                },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Dashboard.route) { inclusive = true }
                    }
                }
            )
        }
    }
}
