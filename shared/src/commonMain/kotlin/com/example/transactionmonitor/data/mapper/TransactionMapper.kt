package com.example.transactionmonitor.data.mapper

import com.example.transactionmonitor.data.dto.TransactionDto
import com.example.transactionmonitor.domain.model.Transaction
import com.example.transactionmonitor.domain.model.TransactionDirection
import com.example.transactionmonitor.domain.model.TransactionStatus
import com.example.transactionmonitor.domain.model.TransactionType

fun TransactionDto.toDomain(): Transaction {
    val domainDirection = when (direction.uppercase()) {
        "SENT" -> TransactionDirection.SENT
        "RECEIVED" -> TransactionDirection.RECEIVED
        else -> TransactionDirection.SENT
    }
    val domainType = when (transactionType.uppercase()) {
        "NFC_TRANSFER" -> TransactionType.NFC_TRANSFER
        "NFC_TOP_UP" -> TransactionType.NFC_TOP_UP
        "STORE_PAYMENT" -> TransactionType.STORE_PAYMENT
        "MONEY_TRANSFER" -> TransactionType.MONEY_TRANSFER
        else -> TransactionType.NFC_TRANSFER
    }
    val domainStatus = when (status.uppercase()) {
        "SUCCESS" -> TransactionStatus.SUCCESS
        "FAILED" -> TransactionStatus.FAILED
        "PENDING" -> TransactionStatus.PENDING
        else -> TransactionStatus.SUCCESS
    }
    return Transaction(
        id = id,
        title = title,
        amount = amount,
        currency = currency,
        direction = domainDirection,
        dateTime = dateTime,
        transactionType = domainType,
        deviceId = deviceId,
        nfcCardId = nfcCardId,
        utrNumber = utrNumber,
        status = domainStatus,
        balance = balance
    )
}

fun Transaction.toDto(): TransactionDto {
    return TransactionDto(
        id = id,
        title = title,
        amount = amount,
        currency = currency,
        direction = direction.name,
        dateTime = dateTime,
        transactionType = transactionType.name,
        deviceId = deviceId,
        nfcCardId = nfcCardId,
        utrNumber = utrNumber,
        status = status.name,
        balance = balance
    )
}
