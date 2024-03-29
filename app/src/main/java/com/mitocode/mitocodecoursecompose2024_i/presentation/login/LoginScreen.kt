package com.mitocode.mitocodecoursecompose2024_i.presentation.login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mitocode.mitocodecoursecompose2024_i.R
import com.mitocode.mitocodecoursecompose2024_i.data.networking.model.LoginRequest
import com.mitocode.mitocodecoursecompose2024_i.data.networking.Api
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.ButtonComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.ImageComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.OutlinedButtonComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.OutlinedTextFieldComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.SpacerComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.TextAnnotationStringComponent
import com.mitocode.mitocodecoursecompose2024_i.presentation.common.TextComponent
import com.mitocode.mitocodecoursecompose2024_i.ui.theme.PrimaryButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//Suscribir el viewmodel
//Inyección de dependecias : HILT , DAGGER, KOIN
@Composable
fun LoginScreen(
    viewmodel: LoginViewModel = hiltViewModel(),
    onNavigateHome:()->Unit
) {

    val state = viewmodel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = state.successfull, key2 = state.error){
        if(state.error!=null){
            Toast.makeText(context,"${state.error}",Toast.LENGTH_LONG).show()
        }
        if(state.successfull!=null){
            //Navigate to Home
            Toast.makeText(context,"Bienvenido",Toast.LENGTH_LONG).show()
            onNavigateHome()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            HeaderLogin()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
        ) {
            ContentLogin(viewmodel)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FooterLogin()
        }

    }

}


@Composable
fun HeaderLogin() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImageComponent(
            image = R.drawable.logo_ecoeats,
            description = "Logo Eco eats",
            modifier = Modifier.size(150.dp)
        )
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentLogin(viewmodel: LoginViewModel) {

    var email by remember {
        mutableStateOf("jledesma2509@gmail.com")
    }

    var password by remember {
        mutableStateOf("123")
    }

    var visualTransformation by remember {
        mutableStateOf(false)
    }


    TextComponent(
        text = "Login",
        style = TextStyle(
            color = PrimaryButton,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    )

    OutlinedTextFieldComponent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        text = email,
        cornerShapeDp = 24.dp,
        textLabel = "Correo",
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PrimaryButton,
            unfocusedBorderColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {

            }
        ),
        trailingIcon = {
            IconButton(onClick = { email = "" }) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Clear"
                )
            }
        },
        onValueChange = {
            email = it
        }
    )

    OutlinedTextFieldComponent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        text = password,
        cornerShapeDp = 24.dp,
        textLabel = "Contraseña",
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PrimaryButton,
            unfocusedBorderColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {

            }
        ),
        trailingIcon = {
            IconButton(onClick = { visualTransformation = !visualTransformation }) {
                Icon(
                    imageVector = if (visualTransformation)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff,
                    contentDescription = "Clear"
                )
            }
        },
        visualTransformation = if (visualTransformation) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        onValueChange = {
            password = it
        }
    )

    if (viewmodel.state.isLoading) {
        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = PrimaryButton,
                strokeWidth = 4.dp
            )
        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        ButtonComponent(
            text = "Ingresar",
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            containerColor = PrimaryButton,
            contentColor = Color.White,
            onClickButton = {
                viewmodel.signIn(email,password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )

    }


}

@Composable
fun FooterLogin() {

    TextAnnotationStringComponent(
        text = buildAnnotatedString {
            append("¿Olvidaste tu contraseña?.")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = PrimaryButton)) {
                append(" Ingrese aquí")
            }
        },
        style = TextStyle(
            fontWeight = FontWeight.Normal
        )
    )
    SpacerComponent(modifier = Modifier.height(64.dp))
    TextComponent(
        text = "¿Un no tienes una cuenta?",
        style = TextStyle(
            fontWeight = FontWeight.Normal
        )
    )
    SpacerComponent(modifier = Modifier.height(16.dp))

    OutlinedButtonComponent(
        text = "Registrate",
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ),
        containerColor = Color.White,
        contentColor = PrimaryButton,
        onClickButton = {

        },
        border = BorderStroke(width = 1.dp, color = PrimaryButton),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 24.dp)
    )


}

@Preview(name = "LoginScreen", showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    //LoginScreen()
}

/*GlobalScope.launch(Dispatchers.Main) {

       val response = withContext(Dispatchers.IO) {
           Api.build().logIn(LoginRequest(email = "jledesma2509@gmail.com", password = "123"))
       }
       println(response.body()?.message)
   }*/
