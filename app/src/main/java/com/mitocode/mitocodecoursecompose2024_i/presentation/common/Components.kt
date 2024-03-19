package com.mitocode.mitocodecoursecompose2024_i.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mitocode.mitocodecoursecompose2024_i.R
import com.mitocode.mitocodecoursecompose2024_i.presentation.home.BottomNavigationItem
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryButton


@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    description: String
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle
) {
    Text(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun TextAnnotationStringComponent(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    style: TextStyle
) {
    Text(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun SpacerComponent(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier)
}

// name:(Valor que vas a dejar)->Retorno
@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    containerColor: Color,
    contentColor: Color,
    onClickButton:()->Unit
) {
    Button(
        onClick = { onClickButton() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        )
    ) {
        Text(
            text = text,
            style = style
        )
    }
}

@Preview(name = "Button")
@Composable
fun ButtonComponentPreview() {
    ButtonComponent(
        text = "Texto",
        style = TextStyle(
            fontWeight = FontWeight.Bold
        ),
        contentColor = Color.White,
        containerColor = PrimaryButton,
        onClickButton = {}
    )
}

@Composable
fun OutlinedButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    containerColor: Color,
    contentColor: Color,
    border: BorderStroke,
    onClickButton:()->Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { onClickButton },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        border = border
    ) {
        Text(
            text = text,
            style = style
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldComponent(
    modifier: Modifier = Modifier,
    text:String,
    cornerShapeDp:Dp,
    textLabel:String,
    colors:TextFieldColors,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange:(String)->Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        shape = RoundedCornerShape(cornerShapeDp),
        label = {
            Text(
                text = textLabel
            )
        },
        colors = colors,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    modifier: Modifier = Modifier,
    text:String,
    backgroundColor:Color = Color.White
) {
    //CenterAlignedTopAppBar(title = { /*TODO*/ })
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = text,
                fontSize = 20.sp
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = backgroundColor
        ),
        actions = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                tint = Color.Black
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = Color.Black
            )
        }
    )
}

@Composable
fun NavigationBarComponent(
    modifier : Modifier = Modifier,
    items:List<BottomNavigationItem>,
    onNavigationItem:(BottomNavigationItem)->Unit
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    onNavigationItem(item)
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unSelectedIcon,
                        contentDescription = item.title,
                        tint = if (index == selectedItemIndex) {
                            PrimaryButton
                        }else{
                            Color.Black
                        }
                    )
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}