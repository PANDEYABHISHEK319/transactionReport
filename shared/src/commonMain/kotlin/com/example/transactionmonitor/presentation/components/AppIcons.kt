package com.example.transactionmonitor.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun NfcIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.White
) {
    Canvas(modifier = modifier.size(28.dp)) {
        val strokeWidth = 2.5f
        drawArc(
            color = tint,
            startAngle = -45f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(size.width * 0.2f, size.height * 0.2f),
            size = Size(size.width * 0.6f, size.height * 0.6f),
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )
        drawArc(
            color = tint,
            startAngle = -45f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(size.width * 0.05f, size.height * 0.05f),
            size = Size(size.width * 0.9f, size.height * 0.9f),
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )
        drawCircle(
            color = tint,
            radius = 3f,
            center = Offset(size.width * 0.5f, size.height * 0.5f)
        )
    }
}

@Composable
fun SendMoneyIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1976D2)
) {
    Canvas(modifier = modifier.size(24.dp)) {
        val strokeWidth = 2.5f
        drawLine(
            color = tint,
            start = Offset(size.width * 0.2f, size.height * 0.8f),
            end = Offset(size.width * 0.8f, size.height * 0.2f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = tint,
            start = Offset(size.width * 0.4f, size.height * 0.2f),
            end = Offset(size.width * 0.8f, size.height * 0.2f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = tint,
            start = Offset(size.width * 0.8f, size.height * 0.2f),
            end = Offset(size.width * 0.8f, size.height * 0.6f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun ReceiveMoneyIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1976D2)
) {
    Canvas(modifier = modifier.size(24.dp)) {
        val strokeWidth = 2.5f
        drawLine(
            color = tint,
            start = Offset(size.width * 0.8f, size.height * 0.2f),
            end = Offset(size.width * 0.2f, size.height * 0.8f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = tint,
            start = Offset(size.width * 0.6f, size.height * 0.8f),
            end = Offset(size.width * 0.2f, size.height * 0.8f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = tint,
            start = Offset(size.width * 0.2f, size.height * 0.8f),
            end = Offset(size.width * 0.2f, size.height * 0.4f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun WalletIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1976D2)
) {
    Canvas(modifier = modifier.size(24.dp)) {
        val strokeWidth = 2.0f
        drawRect(
            color = tint,
            topLeft = Offset(size.width * 0.1f, size.height * 0.3f),
            size = Size(size.width * 0.8f, size.height * 0.6f),
            style = Stroke(width = strokeWidth)
        )
        drawCircle(
            color = tint,
            radius = 3f,
            center = Offset(size.width * 0.7f, size.height * 0.6f)
        )
        drawLine(
            color = tint,
            start = Offset(size.width * 0.1f, size.height * 0.45f),
            end = Offset(size.width * 0.9f, size.height * 0.45f),
            strokeWidth = strokeWidth
        )
    }
}

@Composable
fun ScanIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.White
) {
    Canvas(modifier = modifier.size(24.dp)) {
        val strokeWidth = 2.5f
        val w = size.width
        val h = size.height
        // Top-left
        drawLine(color = tint, start = Offset(0f, h * 0.3f), end = Offset(0f, 0f), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        drawLine(color = tint, start = Offset(0f, 0f), end = Offset(w * 0.3f, 0f), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        // Top-right
        drawLine(color = tint, start = Offset(w * 0.7f, 0f), end = Offset(w, 0f), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        drawLine(color = tint, start = Offset(w, 0f), end = Offset(w, h * 0.3f), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        // Bottom-left
        drawLine(color = tint, start = Offset(0f, h * 0.7f), end = Offset(0f, h), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        drawLine(color = tint, start = Offset(0f, h), end = Offset(w * 0.3f, h), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        // Bottom-right
        drawLine(color = tint, start = Offset(w * 0.7f, h), end = Offset(w, h), strokeWidth = strokeWidth, cap = StrokeCap.Round)
        drawLine(color = tint, start = Offset(w, h * 0.7f), end = Offset(w, h), strokeWidth = strokeWidth, cap = StrokeCap.Round)
    }
}

@Composable
fun HistoryIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1976D2)
) {
    Canvas(modifier = modifier.size(24.dp)) {
        val strokeWidth = 2.0f
        drawCircle(
            color = tint,
            radius = size.minDimension * 0.4f,
            center = center,
            style = Stroke(width = strokeWidth)
        )
        drawLine(
            color = tint,
            start = center,
            end = Offset(center.x, center.y - size.height * 0.2f),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = tint,
            start = center,
            end = Offset(center.x + size.width * 0.2f, center.y),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun ShoppingCartIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1976D2)
) {
    Canvas(modifier = modifier.size(24.dp)) {
        val strokeWidth = 2.0f
        drawRect(
            color = tint,
            topLeft = Offset(size.width * 0.15f, size.height * 0.25f),
            size = Size(size.width * 0.7f, size.height * 0.45f),
            style = Stroke(width = strokeWidth)
        )
        drawCircle(color = tint, radius = 2.5f, center = Offset(size.width * 0.35f, size.height * 0.8f))
        drawCircle(color = tint, radius = 2.5f, center = Offset(size.width * 0.75f, size.height * 0.8f))
    }
}
