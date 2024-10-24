package com.api.myfilelocker.com.api.myfilelocker.ui

import android.graphics.Color
import android.graphics.Path
import android.graphics.PointF
import android.graphics.Rect
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

abstract class Tab {
    abstract val id: Int
    abstract val title: String
    abstract val subtitle: String
    abstract var onTabClicked: () -> Unit
    abstract var onTabResumed: () -> Unit
    abstract var onTabStopped: () -> Unit
    abstract var onTabStarted: () -> Unit
}
