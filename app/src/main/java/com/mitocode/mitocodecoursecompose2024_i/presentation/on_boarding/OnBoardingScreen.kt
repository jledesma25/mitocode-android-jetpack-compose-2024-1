package com.mitocode.mitocodecoursecompose2024_i.presentation.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mitocode.mitocodecoursecompose2024_i.R
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.ImageComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.TextComponent
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryButton
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryText


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            count = 3,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
        ) {
            PagerOnBoarding()
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PagerFooter()
        }

    }

}

@Composable
fun PagerOnBoarding() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        ImageComponent(
            image = R.drawable.image01,
            description = "Image 01",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f)
        )
        TextComponent(
            text = "Explorer",
            style = TextStyle(
                color = PrimaryButton,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        )
        TextComponent(
            text = "Lorem Ipsum is simply dummy text of the\n" +
                    "printing and typesetting industry.",
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = PrimaryText
            ),
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(horizontal = 24.dp)
        )

    }

}

@Composable
fun PagerFooter() {

    repeat(3){
        Box(modifier = Modifier
            .padding(2.dp)
            .clip(CircleShape)
            .background(PrimaryButton)
            .size(12.dp)
        )
    }

}


@Preview(name = "Onboarding", showSystemUi = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}