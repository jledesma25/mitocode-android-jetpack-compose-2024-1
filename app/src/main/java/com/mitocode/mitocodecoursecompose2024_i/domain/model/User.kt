package com.mitocode.mitocodecoursecompose2024_i.domain.model

import com.mitocode.mitocodecoursecompose2024_i.data.model.UserDTO

data class User(
    val id:Int,
    val email:String
)

fun UserDTO.toUser() : User{
    return User(
        id = this.id,
        email = this.email
    )
}