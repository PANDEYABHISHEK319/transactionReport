package com.example.transactionmonitor.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryBlueVariant,
    secondary = SecondaryTeal,
    background = BackgroundLight,
    surface = SurfaceLight,
    onBackground = OnBackground,
    onSurface = OnSurface,
    error = FailedRed
)

private val DarkColors = darkColorScheme(
    primary = PrimaryBlue,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryBlueVariant,
    secondary = SecondaryTeal,
    background = BackgroundDark,
    surface = SurfaceDark,
    onBackground = OnBackgroundDark,
    onSurface = OnSurfaceDark,
    error = FailedRed
)

@Composable
fun TransactionMonitorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
