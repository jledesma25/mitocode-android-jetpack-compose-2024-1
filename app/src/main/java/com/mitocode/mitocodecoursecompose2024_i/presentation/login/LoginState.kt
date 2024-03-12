package com.mitocode.mitocodecoursecompose2024_i.presentation.login

data class LoginState(
    val isLoading:Boolean=false,
    val error:String?=null,
    val successfull:String?=null
)
