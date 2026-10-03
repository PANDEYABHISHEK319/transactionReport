package com.example.transactionmonitor.presentation.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Dashboard : Screen("dashboard")
    data object Transactions : Screen("transactions")
    data object TransactionDetails : Screen("transactions/{transactionId}") {
        fun createRoute(transactionId: String) = "transactions/$transactionId"
    }
    data object Scan : Screen("scan")
    data object SendToNfc : Screen("send_to_nfc")
    data object SendMoney : Screen("send_money")
    data object RequestMoney : Screen("request_money")
    data object Balance : Screen("balance")
    data object DeviceStatus : Screen("device_status")
    data object Notifications : Screen("notifications")
    data object Profile : Screen("profile")
}
