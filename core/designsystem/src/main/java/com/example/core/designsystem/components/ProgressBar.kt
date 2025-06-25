package com.example.core.designsystem.components

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun ProgressBar(
    progress: Int = 30,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    strokeCap: StrokeCap = StrokeCap.Butt
) {
    LinearProgressIndicator(
        progress = { progress / 100f },
        modifier = modifier,
        color = color,
        trackColor = backgroundColor,
        strokeCap = strokeCap
    )
}

