package com.mitocode.mitocodecoursecompose2024_i.presentation.on_boarding

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.ButtonComponent
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryButton

@Composable
fun OnBoardingScreen() {
    Text(text = "Onboarding")

}

@Preview(name = "Onboarding", showSystemUi = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}