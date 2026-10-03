package com.example.transactionmonitor.presentation.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object AppColors {
    val PrimaryBlue = Color(0xFF1976D2)
    val DarkBlue = Color(0xFF0D47A1)
    val SuccessGreen = Color(0xFF16A34A)
    val ErrorRed = Color(0xFFEF4444)
    val WarningOrange = Color(0xFFF59E0B)
    val Purple = Color(0xFF7C3AED)
    val Neutral = Color(0xFF64748B)
}

object AppVectorIcons {

    // 1. NFC Transaction Icon
    val NfcTransaction: ImageVector = ImageVector.Builder(
        name = "NfcTransaction",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(16f, 2f)
        horizontalLineTo(8f)
        curveTo(6.9f, 2f, 6f, 2.9f, 6f, 4f)
        verticalLineTo(20f)
        curveTo(6f, 21.1f, 6.9f, 22f, 8f, 22f)
        horizontalLineTo(16f)
        curveTo(17.1f, 22f, 18f, 21.1f, 18f, 20f)
        verticalLineTo(4f)
        curveTo(18f, 2.9f, 17.1f, 2f, 16f, 2f)
        close()
        moveTo(19.5f, 8.5f)
        curveTo(20.4f, 9.7f, 20.4f, 11.3f, 19.5f, 12.5f)
        moveTo(21.5f, 6.5f)
        curveTo(23f, 8.5f, 23f, 11.5f, 21.5f, 13.5f)
    }.build()

    // 2. NFC Tap Icon
    val NfcTap: ImageVector = ImageVector.Builder(
        name = "NfcTap",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(6f, 9f)
        curveTo(8f, 7f, 11f, 7f, 13f, 9f)
        moveTo(4f, 6f)
        curveTo(7.5f, 2.5f, 12.5f, 2.5f, 16f, 6f)
        moveTo(8f, 12f)
        curveTo(9f, 11f, 10f, 11f, 11f, 12f)
        moveTo(12f, 18f)
        horizontalLineTo(12.01f)
    }.build()

    // 3. To NFC Icon
    val ToNfc: ImageVector = ImageVector.Builder(
        name = "ToNfc",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(2f, 12f)
        horizontalLineTo(14f)
        moveTo(10f, 8f)
        lineTo(14f, 12f)
        lineTo(10f, 16f)
        moveTo(18f, 8f)
        curveTo(19.5f, 9.5f, 19.5f, 14.5f, 18f, 16f)
        moveTo(21f, 5f)
        curveTo(23.5f, 8f, 23.5f, 16f, 21f, 19f)
    }.build()

    // 4. Send Money Icon
    val SendMoney: ImageVector = ImageVector.Builder(
        name = "SendMoney",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.DarkBlue),
        strokeLineWidth = 2.5f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 5f)
        verticalLineTo(19f)
        moveTo(5f, 12f)
        horizontalLineTo(19f)
    }.build()

    // 5. Request Money Icon
    val RequestMoney: ImageVector = ImageVector.Builder(
        name = "RequestMoney",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Purple),
        strokeLineWidth = 2.2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 6f)
        verticalLineTo(18f)
        moveTo(6f, 12f)
        horizontalLineTo(18f)
    }.build()

    // 6. Check Balance Icon (Wallet)
    val Wallet: ImageVector = ImageVector.Builder(
        name = "Wallet",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.WarningOrange),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(20f, 7f)
        horizontalLineTo(4f)
        curveTo(2.9f, 7f, 2f, 7.9f, 2f, 9f)
        verticalLineTo(18f)
        curveTo(2f, 19.1f, 2.9f, 20f, 4f, 20f)
        horizontalLineTo(20f)
        curveTo(21.1f, 20f, 22f, 19.1f, 22f, 18f)
        verticalLineTo(9f)
        curveTo(22f, 7.9f, 21.1f, 7f, 20f, 7f)
        close()
        moveTo(16f, 14f)
        horizontalLineTo(18f)
        moveTo(20f, 7f)
        verticalLineTo(5f)
        curveTo(20f, 3.9f, 19.1f, 3f, 18f, 3f)
        horizontalLineTo(6f)
        curveTo(4.9f, 3f, 4f, 3.9f, 4f, 5f)
        verticalLineTo(7f)
    }.build()

    // 7. Scan Icon
    val Scan: ImageVector = ImageVector.Builder(
        name = "Scan",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(4f, 8f)
        verticalLineTo(6f)
        curveTo(4f, 4.9f, 4.9f, 4f, 6f, 4f)
        horizontalLineTo(8f)
        moveTo(16f, 4f)
        horizontalLineTo(18f)
        curveTo(19.1f, 4f, 20f, 4.9f, 20f, 6f)
        verticalLineTo(8f)
        moveTo(20f, 16f)
        verticalLineTo(18f)
        curveTo(20f, 19.1f, 19.1f, 20f, 18f, 20f)
        horizontalLineTo(16f)
        moveTo(8f, 20f)
        horizontalLineTo(6f)
        curveTo(4.9f, 20f, 4f, 19.1f, 4f, 18f)
        verticalLineTo(16f)
        moveTo(9f, 9f)
        horizontalLineTo(11f)
        verticalLineTo(11f)
        horizontalLineTo(9f)
        close()
        moveTo(13f, 13f)
        horizontalLineTo(15f)
        verticalLineTo(15f)
        horizontalLineTo(13f)
        close()
        moveTo(13f, 9f)
        horizontalLineTo(15f)
        verticalLineTo(11f)
        horizontalLineTo(13f)
        close()
        moveTo(9f, 13f)
        horizontalLineTo(11f)
        verticalLineTo(15f)
        horizontalLineTo(9f)
        close()
    }.build()

    // 8. History Icon
    val History: ImageVector = ImageVector.Builder(
        name = "History",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 8f)
        verticalLineTo(12f)
        lineTo(15f, 15f)
        moveTo(3.05f, 11f)
        curveTo(3.56f, 6.52f, 7.37f, 3f, 12f, 3f)
        curveTo(16.97f, 3f, 21f, 7.03f, 21f, 12f)
        curveTo(21f, 16.97f, 16.97f, 21f, 12f, 21f)
        curveTo(7.5f, 21f, 3.82f, 17.75f, 3.09f, 13.5f)
        moveTo(3f, 4f)
        verticalLineTo(11f)
        horizontalLineTo(10f)
    }.build()

    // 9. Send Transaction Icon (Upward arrow)
    val SendTransaction: ImageVector = ImageVector.Builder(
        name = "SendTransaction",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2.2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 19f)
        verticalLineTo(5f)
        moveTo(5f, 12f)
        lineTo(12f, 5f)
        lineTo(19f, 12f)
    }.build()

    // 10. Receive Transaction Icon (Downward arrow)
    val ReceiveTransaction: ImageVector = ImageVector.Builder(
        name = "ReceiveTransaction",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.SuccessGreen),
        strokeLineWidth = 2.2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 5f)
        verticalLineTo(19f)
        moveTo(5f, 12f)
        lineTo(12f, 19f)
        lineTo(19f, 12f)
    }.build()

    // 11. Store Payment Icon
    val StorePayment: ImageVector = ImageVector.Builder(
        name = "StorePayment",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.WarningOrange),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(6f, 2f)
        horizontalLineTo(3f)
        moveTo(6f, 2f)
        lineTo(8f, 14f)
        horizontalLineTo(19f)
        lineTo(21f, 6f)
        horizontalLineTo(7.5f)
        moveTo(9f, 20f)
        curveTo(9f, 20.6f, 8.6f, 21f, 8f, 21f)
        curveTo(7.4f, 21f, 7f, 20.6f, 7f, 20f)
        curveTo(7f, 19.4f, 7.4f, 19f, 8f, 19f)
        curveTo(8.6f, 19f, 9f, 19.4f, 9f, 20f)
        close()
        moveTo(20f, 20f)
        curveTo(20f, 20.6f, 19.6f, 21f, 19f, 21f)
        curveTo(18.4f, 21f, 18f, 20.6f, 18f, 20f)
        curveTo(18f, 19.4f, 18.4f, 19f, 19f, 19f)
        curveTo(19.6f, 19f, 20f, 19.4f, 20f, 20f)
        close()
    }.build()

    // 12. NFC Top-Up Icon
    val NfcTopUp: ImageVector = ImageVector.Builder(
        name = "NfcTopUp",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Purple),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 2f)
        curveTo(6.5f, 2f, 2f, 6.5f, 2f, 12f)
        curveTo(2f, 17.5f, 6.5f, 22f, 12f, 22f)
        curveTo(17.5f, 22f, 22f, 17.5f, 22f, 12f)
        moveTo(12f, 8f)
        verticalLineTo(16f)
        moveTo(8f, 12f)
        horizontalLineTo(16f)
    }.build()

    // 13. Success Icon
    val Success: ImageVector = ImageVector.Builder(
        name = "Success",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.SuccessGreen),
        strokeLineWidth = 2.2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(22f, 11.08f)
        verticalLineTo(12f)
        curveTo(22f, 17.52f, 17.52f, 22f, 12f, 22f)
        curveTo(6.48f, 22f, 2f, 17.52f, 2f, 12f)
        curveTo(2f, 6.48f, 6.48f, 2f, 12f, 2f)
        curveTo(13.85f, 2f, 15.58f, 2.5f, 17.07f, 3.35f)
        moveTo(9f, 11f)
        lineTo(12f, 14f)
        lineTo(22f, 4f)
    }.build()

    // 14. Failed Icon
    val Failed: ImageVector = ImageVector.Builder(
        name = "Failed",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.ErrorRed),
        strokeLineWidth = 2.2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 22f)
        curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f)
        curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f)
        curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f)
        curveTo(2f, 17.52f, 6.48f, 22f, 12f, 22f)
        close()
        moveTo(15f, 9f)
        lineTo(9f, 15f)
        moveTo(9f, 9f)
        lineTo(15f, 15f)
    }.build()

    // 15. Pending Icon
    val Pending: ImageVector = ImageVector.Builder(
        name = "Pending",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.WarningOrange),
        strokeLineWidth = 2.2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 22f)
        curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f)
        curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f)
        curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f)
        curveTo(2f, 17.52f, 6.48f, 22f, 12f, 22f)
        close()
        moveTo(12f, 6f)
        verticalLineTo(12f)
        lineTo(16f, 14f)
    }.build()

    // 16. Device Icon
    val Device: ImageVector = ImageVector.Builder(
        name = "Device",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(7f, 2f)
        horizontalLineTo(17f)
        curveTo(18.1f, 2f, 19f, 2.9f, 19f, 4f)
        verticalLineTo(20f)
        curveTo(19f, 21.1f, 18.1f, 22f, 17f, 22f)
        horizontalLineTo(7f)
        curveTo(5.9f, 22f, 5f, 21.1f, 5f, 20f)
        verticalLineTo(4f)
        curveTo(5f, 2.9f, 5.9f, 2f, 7f, 2f)
        close()
        moveTo(9f, 6f)
        horizontalLineTo(15f)
        verticalLineTo(10f)
        horizontalLineTo(9f)
        verticalLineTo(6f)
        close()
    }.build()

    // 17. Online Icon
    val Online: ImageVector = ImageVector.Builder(
        name = "Online",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        fill = SolidColor(AppColors.SuccessGreen)
    ) {
        moveTo(12f, 2f)
        curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f)
        curveTo(2f, 17.52f, 6.48f, 22f, 12f, 22f)
        curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f)
        curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f)
        close()
    }.build()

    // 18. Offline Icon
    val Offline: ImageVector = ImageVector.Builder(
        name = "Offline",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        fill = SolidColor(AppColors.ErrorRed)
    ) {
        moveTo(12f, 2f)
        curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f)
        curveTo(2f, 17.52f, 6.48f, 22f, 12f, 22f)
        curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f)
        curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f)
        close()
    }.build()

    // 19. Sim Icon
    val Sim: ImageVector = ImageVector.Builder(
        name = "Sim",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(4f, 4f)
        horizontalLineTo(16f)
        lineTo(20f, 8f)
        verticalLineTo(20f)
        curveTo(20f, 21.1f, 19.1f, 22f, 18f, 22f)
        horizontalLineTo(4f)
        curveTo(2.9f, 22f, 2f, 21.1f, 2f, 20f)
        verticalLineTo(6f)
        curveTo(2f, 4.9f, 2.9f, 4f, 4f, 4f)
        close()
    }.build()

    // 20. Server Icon
    val Server: ImageVector = ImageVector.Builder(
        name = "Server",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(18f, 10f)
        horizontalLineTo(6f)
        curveTo(3.8f, 10f, 2f, 11.8f, 2f, 14f)
        curveTo(2f, 16.2f, 3.8f, 18f, 6f, 18f)
        horizontalLineTo(18f)
        curveTo(20.2f, 18f, 22f, 16.2f, 22f, 14f)
        curveTo(22f, 11.8f, 20.2f, 10f, 18f, 10f)
        close()
        moveTo(6f, 6f)
        horizontalLineTo(18f)
        curveTo(20.2f, 6f, 22f, 7.8f, 22f, 10f)
        curveTo(22f, 12.2f, 20.2f, 14f, 18f, 14f)
        horizontalLineTo(6f)
        curveTo(3.8f, 14f, 2f, 12.2f, 2f, 10f)
        curveTo(2f, 7.8f, 3.8f, 6f, 6f, 6f)
        close()
    }.build()

    // 21. Battery Icon
    val Battery: ImageVector = ImageVector.Builder(
        name = "Battery",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.SuccessGreen),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(6f, 7f)
        horizontalLineTo(18f)
        curveTo(19.1f, 7f, 20f, 7.9f, 20f, 9f)
        verticalLineTo(15f)
        curveTo(20f, 16.1f, 19.1f, 17f, 18f, 17f)
        horizontalLineTo(6f)
        curveTo(4.9f, 17f, 4f, 16.1f, 4f, 15f)
        verticalLineTo(9f)
        curveTo(4f, 7.9f, 4.9f, 7f, 6f, 7f)
        close()
        moveTo(22f, 10f)
        verticalLineTo(14f)
        moveTo(7f, 10f)
        horizontalLineTo(14f)
        verticalLineTo(14f)
        horizontalLineTo(7f)
        close()
    }.build()

    // 22. Profile Icon
    val Profile: ImageVector = ImageVector.Builder(
        name = "Profile",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(20f, 21f)
        verticalLineTo(19f)
        curveTo(20f, 16.24f, 17.76f, 14f, 15f, 14f)
        horizontalLineTo(9f)
        curveTo(6.24f, 14f, 4f, 16.24f, 4f, 19f)
        verticalLineTo(21f)
        moveTo(12f, 11f)
        curveTo(14.21f, 11f, 16f, 9.21f, 16f, 7f)
        curveTo(16f, 4.79f, 14.21f, 3f, 12f, 3f)
        curveTo(9.79f, 3f, 8f, 4.79f, 8f, 7f)
        curveTo(8f, 9.21f, 9.79f, 11f, 12f, 11f)
        close()
    }.build()

    // 23. Notification Icon
    val Notification: ImageVector = ImageVector.Builder(
        name = "Notification",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(18f, 8f)
        curveTo(18f, 4.69f, 15.31f, 2f, 12f, 2f)
        curveTo(8.69f, 2f, 6f, 4.69f, 6f, 8f)
        curveTo(6f, 15f, 3f, 17f, 3f, 17f)
        horizontalLineTo(21f)
        curveTo(21f, 17f, 18f, 15f, 18f, 8f)
        close()
        moveTo(13.73f, 21f)
        curveTo(13.35f, 21.65f, 12.7f, 22f, 12f, 22f)
        curveTo(11.3f, 22f, 10.65f, 21.65f, 10.27f, 21f)
    }.build()

    // 24. Settings Icon
    val Settings: ImageVector = ImageVector.Builder(
        name = "Settings",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(12f, 15f)
        curveTo(13.66f, 15f, 15f, 13.66f, 15f, 12f)
        curveTo(15f, 10.34f, 13.66f, 9f, 12f, 9f)
        curveTo(10.34f, 9f, 9f, 10.34f, 9f, 12f)
        curveTo(9f, 13.66f, 10.34f, 15f, 12f, 15f)
        close()
        moveTo(19.4f, 15f)
        curveTo(19.57f, 14.15f, 19.81f, 12.85f, 19.4f, 12f)
        moveTo(4.6f, 12f)
        curveTo(4.19f, 12.85f, 4.43f, 14.15f, 4.6f, 15f)
    }.build()

    // 25. Menu Icon
    val Menu: ImageVector = ImageVector.Builder(
        name = "Menu",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(3f, 12f)
        horizontalLineTo(21f)
        moveTo(3f, 6f)
        horizontalLineTo(21f)
        moveTo(3f, 18f)
        horizontalLineTo(21f)
    }.build()

    // 26. Back Icon
    val Back: ImageVector = ImageVector.Builder(
        name = "Back",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(19f, 12f)
        horizontalLineTo(5f)
        moveTo(12f, 19f)
        lineTo(5f, 12f)
        lineTo(12f, 5f)
    }.build()

    // 27. Forward Icon
    val Forward: ImageVector = ImageVector.Builder(
        name = "Forward",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(9f, 18f)
        lineTo(15f, 12f)
        lineTo(9f, 6f)
    }.build()

    // 28. Search Icon
    val Search: ImageVector = ImageVector.Builder(
        name = "Search",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(11f, 19f)
        curveTo(15.42f, 19f, 19f, 15.42f, 19f, 11f)
        curveTo(19f, 6.58f, 15.42f, 3f, 11f, 3f)
        curveTo(6.58f, 3f, 3f, 6.58f, 3f, 11f)
        curveTo(3f, 15.42f, 6.58f, 19f, 11f, 19f)
        close()
        moveTo(21f, 21f)
        lineTo(16.65f, 16.65f)
    }.build()

    // 29. Filter Icon
    val Filter: ImageVector = ImageVector.Builder(
        name = "Filter",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.Neutral),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(22f, 3f)
        horizontalLineTo(2f)
        lineTo(10f, 12.46f)
        verticalLineTo(19f)
        lineTo(14f, 21f)
        verticalLineTo(12.46f)
        lineTo(22f, 3f)
        close()
    }.build()

    // 30. Copy Icon
    val Copy: ImageVector = ImageVector.Builder(
        name = "Copy",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(9f, 9f)
        horizontalLineTo(19f)
        verticalLineTo(19f)
        horizontalLineTo(9f)
        close()
        moveTo(5f, 15f)
        horizontalLineTo(4f)
        curveTo(2.9f, 15f, 2f, 14.1f, 2f, 13f)
        verticalLineTo(4f)
        curveTo(2f, 2.9f, 2.9f, 2f, 4f, 2f)
        horizontalLineTo(13f)
        curveTo(14.1f, 2f, 15f, 2.9f, 15f, 4f)
        verticalLineTo(5f)
    }.build()

    // 31. Share Icon
    val Share: ImageVector = ImageVector.Builder(
        name = "Share",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.PrimaryBlue),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(18f, 5f)
        curveTo(18f, 6.66f, 16.66f, 8f, 15f, 8f)
        curveTo(13.34f, 8f, 12f, 6.66f, 12f, 5f)
        curveTo(12f, 3.34f, 13.34f, 2f, 15f, 2f)
        curveTo(16.66f, 2f, 18f, 3.34f, 18f, 5f)
        close()
        moveTo(6f, 12f)
        curveTo(6f, 13.66f, 4.66f, 15f, 3f, 15f)
        curveTo(1.34f, 15f, 0f, 13.66f, 0f, 12f)
        curveTo(0f, 10.34f, 1.34f, 9f, 3f, 9f)
        curveTo(4.66f, 9f, 6f, 10.34f, 6f, 12f)
        close()
        moveTo(18f, 19f)
        curveTo(18f, 20.66f, 16.66f, 22f, 15f, 22f)
        curveTo(13.34f, 22f, 12f, 20.66f, 12f, 19f)
        curveTo(12f, 17.34f, 13.34f, 16f, 15f, 16f)
        curveTo(16.66f, 16f, 18f, 17.34f, 18f, 19f)
        close()
        moveTo(8.59f, 13.51f)
        lineTo(15.42f, 17.49f)
        moveTo(15.41f, 6.51f)
        lineTo(8.59f, 10.49f)
    }.build()

    // 32. Logout Icon
    val Logout: ImageVector = ImageVector.Builder(
        name = "Logout",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).path(
        stroke = SolidColor(AppColors.ErrorRed),
        strokeLineWidth = 2f,
        strokeLineCap = StrokeCap.Round,
        strokeLineJoin = StrokeJoin.Round
    ) {
        moveTo(9f, 21f)
        horizontalLineTo(5f)
        curveTo(3.9f, 21f, 3f, 20.1f, 3f, 19f)
        verticalLineTo(5f)
        curveTo(3f, 3.9f, 3.9f, 3f, 5f, 3f)
        horizontalLineTo(9f)
        moveTo(16f, 17f)
        lineTo(21f, 12f)
        lineTo(16f, 7f)
        moveTo(21f, 12f)
        horizontalLineTo(9f)
    }.build()
}
