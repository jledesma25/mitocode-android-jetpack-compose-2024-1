package com.mitocode.mitocodecoursecompose2024_i.data.networking

import com.mitocode.mitocodecoursecompose2024_i.data.model.LoginRequest
import com.mitocode.mitocodecoursecompose2024_i.data.model.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object Api {

    //URL O ENDPOINT: http://betolix-001-site1.etempurl.com/api/securities/login
    //VERBO: POST

    //URL BASE: http://betolix-001-site1.etempurl.com/
    //METHOD: api/securities/login
    //URL BASE + METHID = ENDPOINT

    //1. Configure retrofit
    private val builder : Retrofit.Builder = Retrofit.Builder()
        .baseUrl("http://betolix-001-site1.etempurl.com/")
        .addConverterFactory(GsonConverterFactory.create())

    //2. Create methods
    interface HealthyMethods{

        @POST("api/securities/login")
        suspend fun logIn(@Body request:LoginRequest) : Response<LoginResponse>

    }

    //3. Create functions
    fun build() : HealthyMethods{
        return builder.build().create(HealthyMethods::class.java)
    }
    
}