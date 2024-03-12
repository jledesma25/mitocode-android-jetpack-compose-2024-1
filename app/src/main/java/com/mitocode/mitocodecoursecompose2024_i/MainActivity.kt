package com.mitocode.mitocodecoursecompose2024_i

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mitocode.mitocodecoursecompose2024_i.data.networking.Api
import com.mitocode.mitocodecoursecompose2024_i.examples.components.MyFirstComposable
import com.mitocode.mitocodecoursecompose2024_i.examples.components.PlusAndSubstractComponent
import com.mitocode.mitocodecoursecompose2024_i.examples.components.SurveyComponent
import com.mitocode.mitocodecoursecompose2024_i.navigation.SetupNavGraph
import com.mitocode.mitocodecoursecompose2024_i.presentation.login.LoginScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.on_boarding.OnBoardingScreen
import com.mitocode.mitocodecoursecompose2024_i.presentation.welcome.WelcomeScreen
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.MitocodeCourseCompose2024ITheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SetupNavGraph()
        }
    }
}





