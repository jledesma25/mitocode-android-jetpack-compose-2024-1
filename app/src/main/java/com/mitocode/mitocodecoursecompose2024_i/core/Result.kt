package com.mitocode.mitocodecoursecompose2024_i.core

import com.mitocode.mitocodecoursecompose2024_i.data.networking.model.UserDTO

sealed class Result<T>(val data:T?=null,val message:String?=null) {

    class Success<T>(data: T?) : Result<T>(data = data)
    class Error<T>(message: String?) : Result<T>(message = message)
    class Loading<T> : Result<T>()

}

