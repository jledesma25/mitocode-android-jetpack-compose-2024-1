package com.mitocode.mitocodecoursecompose2024_i.examples.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyFirstComposable() {

    //ESTADO: myText
    //EVENTO: onValueChange
    //RECOMPOSICION

    var myText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Mitocode 2024",
            fontSize = 24.sp,
            color = Color.Blue,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(8.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black
                )

        )
        Text(
            text = "Juan José Ledesma"
        )
        OutlinedTextField(
            value = myText,
            onValueChange = {
                myText = it
            }
        )

    }

}

@Preview(name = "Preview 1", showSystemUi = true)
@Composable
fun MyFirstComposablePreview() {
    MyFirstComposable()
}