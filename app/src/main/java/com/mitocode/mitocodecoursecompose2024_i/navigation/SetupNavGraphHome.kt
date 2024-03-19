package com.mitocode.mitocodecoursecompose2024_i.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mitocode.mitocodecoursecompose2024_i.presentation.detail.DishDetailScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.dish.DishScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.search.SearchScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.settings.SettingScreen

@Composable
fun SetupNavGraphHome(paddingValues: PaddingValues, navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = ScreenHome.Dish.route
    ){
        composable(route = ScreenHome.Dish.route){
            DishScreen(paddingValues = paddingValues)
        }
        composable(route = ScreenHome.Search.route){
            SearchScreen(paddingValues = paddingValues)
        }
        composable(route = ScreenHome.Setting.route){
            SettingScreen(paddingValues = paddingValues)
        }
        composable(route = ScreenHome.DishDetail.route){
            DishDetailScreen(paddingValues = paddingValues)
        }
    }

}