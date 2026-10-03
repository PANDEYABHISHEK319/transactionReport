package com.example.transactionmonitor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
