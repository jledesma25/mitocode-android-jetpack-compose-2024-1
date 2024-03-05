package com.mitocode.mitocodecoursecompose2024_i.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mitocode.mitocodecoursecompose2024_i.presentation.login.LoginScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.on_boarding.OnBoardingScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.welcome.WelcomeScreen

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome_screen"
    ){
        composable(route = "welcome_screen"){
            WelcomeScreen(
                onClick = {
                    navController.navigate(route = "onboarding_screen")
                }
            )
        }
        composable(route = "onboarding_screen"){
            OnBoardingScreen()
        }
        composable(route = "login_screen"){
            LoginScreen()
        }
    }
}