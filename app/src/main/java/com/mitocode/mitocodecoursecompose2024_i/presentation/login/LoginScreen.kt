package com.mitocode.mitocodecoursecompose2024_i.presentation.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Text(text = "Login")
}

@Preview(name = "LoginScreen", showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}