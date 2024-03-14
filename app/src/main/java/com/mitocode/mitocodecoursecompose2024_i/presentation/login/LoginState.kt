package com.mitocode.mitocodecoursecompose2024_i.presentation.login

import com.mitocode.mitocodecoursecompose2024_i.domain.model.User

data class LoginState(
    val isLoading:Boolean=false,
    val error:String?=null,
    val successfull:User?=null
)
