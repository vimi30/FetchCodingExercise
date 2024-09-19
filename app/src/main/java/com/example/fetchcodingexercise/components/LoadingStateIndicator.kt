package com.example.fetchcodingexercise.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingStateComponent(modifier: Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
    )
}