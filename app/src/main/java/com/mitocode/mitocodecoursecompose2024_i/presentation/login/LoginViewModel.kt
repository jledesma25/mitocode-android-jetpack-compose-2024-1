package com.mitocode.mitocodecoursecompose2024_i.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(LoginState())

    fun signIn(email:String,password:String){



    }


}