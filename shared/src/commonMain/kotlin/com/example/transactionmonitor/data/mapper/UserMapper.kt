package com.example.transactionmonitor.data.mapper

import com.example.transactionmonitor.data.dto.UserDto
import com.example.transactionmonitor.domain.model.User

fun UserDto.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email,
        mobile = mobile
    )
}
