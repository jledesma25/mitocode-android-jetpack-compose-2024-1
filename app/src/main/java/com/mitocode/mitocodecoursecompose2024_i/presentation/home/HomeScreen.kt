package com.mitocode.mitocodecoursecompose2024_i.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.mitocode.mitocodecoursecompose2024_i.navigation.ScreenHome
import com.mitocode.mitocodecoursecompose2024_i.navigation.SetupNavGraphHome
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.NavigationBarComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.TopAppBarComponent
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryButton

@Composable
fun HomeScreen() {

    val items = listOf(
        BottomNavigationItem(
            title = "Inicio",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
            route = ScreenHome.Dish.route
        ),
        BottomNavigationItem(
            title = "Encuentranos",
            selectedIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Outlined.Search,
            route = ScreenHome.Search.route
        ),
        BottomNavigationItem(
            title = "Configuración",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings,
            route = ScreenHome.Setting.route
        )
    )

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarComponent(
                text = "",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        },
        bottomBar = {
            NavigationBarComponent(
                items = items,
                onNavigationItem = { item ->
                    navController.navigate(item.route){
                        //popUpTo(navController.graph.findStartDestination().id){
                        //    saveState = true
                        //},
                        launchSingleTop = true
                    }
                }
            )
        },
    ) { paddingValues ->
        SetupNavGraphHome(paddingValues,navController)
    }

}


@Preview(name = "", showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}