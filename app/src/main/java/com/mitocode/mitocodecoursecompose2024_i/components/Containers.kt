package com.mitocode.mitocodecoursecompose2024_i.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxComponent() {

    Box(
        modifier = Modifier
            //.width(300.dp)
            //.height(400.dp)
            .fillMaxSize()
            .background(Color.Blue)
            .padding(top = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Star",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
        )
    }

}

@Preview(name = "Preview 1", showSystemUi = true)
@Composable
fun BoxComponentPreview() {
    BoxComponent()
}


@Composable
fun ColumnComponent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Box(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(Color.Red)
        ) {

        }
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(Color.Blue)
        ) {

        }
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(Color.Green)
        ) {

        }

    }

}

@Preview(name = "Preview 2", showSystemUi = true)
@Composable
fun ColumnComponentPreview() {
    ColumnComponent()
}

@Composable
fun RowComponent() {
    

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
        
    ) {
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(Color.Red)
        ) {

        }
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(Color.Blue)
        ) {

        }
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(Color.Green)
        ) {

        }
    }

}

@Preview(name = "Preview 3", showSystemUi = true)
@Composable
fun RowComponentPreview() {
    RowComponent()
}

