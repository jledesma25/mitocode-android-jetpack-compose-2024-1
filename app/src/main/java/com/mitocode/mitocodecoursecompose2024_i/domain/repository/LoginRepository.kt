package com.mitocode.mitocodecoursecompose2024_i.domain.repository

import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun signIn(email:String, password:String) : Flow<Result<User>>

    
}