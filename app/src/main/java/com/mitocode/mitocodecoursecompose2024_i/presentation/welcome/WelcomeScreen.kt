package com.mitocode.mitocodecoursecompose2024_i.presentation.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mitocode.mitocodecoursecompose2024_i.R
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.ButtonComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.ImageComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.SpacerComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.TextComponent
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.Primary
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryButton

@Composable
fun WelcomeScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            WelcomeHeader()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            WelcomeContent(
                onClick = {
                    onClick()
                }
            )
        }

    }

}

@Composable
fun WelcomeHeader() {

    Column {

        ImageComponent(
            image = R.drawable.logo_ecoeats ,
            description = "Logo Ecoeats",
            modifier = Modifier
                .fillMaxWidth()
                .size(25.dp)
        )
        SpacerComponent(modifier = Modifier.height(12.dp))
        TextComponent(
            text = "Una vida saludable",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = Primary
            ),
            modifier = Modifier.fillMaxWidth()
        )


    }

}

@Composable
fun WelcomeContent(onClick:()->Unit) {

    ImageComponent(
        image = R.drawable.background_fruits,
        description = "Background Fruits",
        modifier = Modifier.fillMaxSize()
    )
    ButtonComponent(
        text = "Empezar",
        style = TextStyle(
            fontWeight = FontWeight.Bold
        ),
        contentColor = Color.White,
        containerColor = PrimaryButton,
        modifier = Modifier.padding(bottom = 50.dp),
        onClickButton = {
           onClick()
        }

    )

}

@Preview(showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onClick = {})
}