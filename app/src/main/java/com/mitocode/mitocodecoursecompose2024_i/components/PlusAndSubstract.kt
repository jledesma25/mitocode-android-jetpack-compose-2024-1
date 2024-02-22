package com.mitocode.mitocodecoursecompose2024_i.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlusAndSubstractComponent() {
    
    //ESTADO: quantity
    //EVENTO: onclick
    //RECOMPOSICION

    var quantity by remember {
        mutableStateOf(0)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { quantity++ }) {
            Text(text = "+")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$quantity",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { quantity-- }) {
            Text(text = "-")
        }
    }

}

@Preview(name = "Preview", showSystemUi = true)
@Composable
fun PlusAndSubstractComponentPreview() {
    PlusAndSubstractComponent()
}