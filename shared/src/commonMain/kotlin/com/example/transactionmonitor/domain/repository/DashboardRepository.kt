package com.example.transactionmonitor.domain.repository

import com.example.transactionmonitor.domain.model.DashboardSummary

interface DashboardRepository {
    suspend fun getDashboardSummary(): Result<DashboardSummary>
}
