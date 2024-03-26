package com.mitocode.mitocodecoursecompose2024_i.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.data.model.LoginRequest
import com.mitocode.mitocodecoursecompose2024_i.data.model.UserDTO
import com.mitocode.mitocodecoursecompose2024_i.data.networking.Api
import com.mitocode.mitocodecoursecompose2024_i.domain.model.User
import com.mitocode.mitocodecoursecompose2024_i.domain.model.toUser
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

//RETROFIT -> API
class LoginRepositoryImp @Inject constructor(val sharedPreferences: SharedPreferences) : LoginRepository {
    override suspend fun signIn(email: String, password: String) : Flow<Result<User>> = flow {
        try{

            emit(Result.Loading())

            val response = Api.build().logIn(
                LoginRequest(
                    email = email,
                    password = password
                )
            )

            if(response.isSuccessful){
                //La respuesta fue satisfactoria
                val loginResponse = response.body()

                if(loginResponse?.success == true){
                    //Usuario existe
                    sharedPreferences.edit().putString("KEY_TOKEN",loginResponse.data.token).apply()
                    emit(Result.Success(data = loginResponse.data.toUser()))
                }else{
                    //Usuario no existe
                    emit(Result.Error(message = loginResponse?.message))
                }

            }else{
                //Hubo algun error o advertencia
                 emit(Result.Error(message = response.message()))
            }
        }
        catch (ex:IOException){
            emit(Result.Error(message = "Compruebe su conexión al internet"))
        }
        catch (ex:Exception){
            emit(Result.Error(message = ex.message))
        }
    }


}