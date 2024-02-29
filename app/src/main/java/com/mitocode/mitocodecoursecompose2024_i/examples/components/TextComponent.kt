package com.mitocode.mitocodecoursecompose2024_i.examples.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextComponent() {

    //Estado: myText
    //Evento: onValueChange
    //RECOMPOSICIÓN

    var myText by remember {
        mutableStateOf("")
    }

    Column {
        OutlinedTextField(
            value = myText,
            onValueChange = { text ->
                myText = text
            }
        )
        Text(text = myText)

    }

}

@Composable
fun VisibilityComponent() {

    //Estado: visibility : Boolean
    //Evento: onClick
    //RECOMPOSITION

    var visibility by remember {
        mutableStateOf(false) //true: muestra //false: oculta
    }

    Row {
        Button(onClick = { visibility = true }) {
            Text(text = "Visible")
        }
        Button(onClick = { visibility = false }) {
            Text(text = "Invisible")
        }
        if(visibility){
            Text(text = "MITOCODE")
        }

    }
    
}

@Preview(showSystemUi = true)
@Composable
fun VisibilityComponentPreview() {
    VisibilityComponent()
}

@Preview(showSystemUi = true)
@Composable
fun TextComponentPreview() {
    TextComponent()
}