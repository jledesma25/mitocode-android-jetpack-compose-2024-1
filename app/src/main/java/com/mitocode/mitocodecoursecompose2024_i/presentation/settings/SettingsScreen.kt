package com.mitocode.mitocodecoursecompose2024_i.presentation.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingScreen(paddingValues: PaddingValues) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        Text(text = "Settings")
    }
}

@Preview(name = "", showSystemUi = true)
@Composable
fun SettingScreenPreview() {
    //SettingScreen(paddingValues)
}