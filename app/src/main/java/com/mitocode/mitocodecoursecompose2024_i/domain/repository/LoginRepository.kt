package com.mitocode.mitocodecoursecompose2024_i.domain.repository

interface LoginRepository {

    fun signIn(email:String, password:String) : Unit

    
}