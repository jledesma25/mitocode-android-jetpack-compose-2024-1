package com.mitocode.mitocodecoursecompose2024_i.presentation.login

import com.mitocode.mitocodecoursecompose2024_i.data.model.UserDTO

data class LoginState(
    val isLoading:Boolean=false,
    val error:String?=null,
    val successfull:UserDTO?=null
)
