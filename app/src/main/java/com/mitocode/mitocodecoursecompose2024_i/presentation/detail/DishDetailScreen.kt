package com.mitocode.mitocodecoursecompose2024_i.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mitocode.mitocodecoursecompose2024_i.domain.model.Dish
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.SpacerComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.TextComponent

@Composable
fun DishDetailScreen(paddingValues: PaddingValues, dish: Dish) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dish.thumbails)
                    .crossfade(1000)
                    .build(),
                contentDescription = dish.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            SpacerComponent(modifier = Modifier.height(16.dp))
            TextComponent(
                text = dish.name,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            TextComponent(
                text = dish.description,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

    }

}

@Preview(name = "", showSystemUi = true)
@Composable
fun DishDetailScreenPreview() {
    //DishDetailScreen(paddingValues)
}