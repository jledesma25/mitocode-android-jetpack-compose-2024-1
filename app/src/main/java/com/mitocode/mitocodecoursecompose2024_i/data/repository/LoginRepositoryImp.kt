package com.mitocode.mitocodecoursecompose2024_i.data.repository

import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.data.model.LoginRequest
import com.mitocode.mitocodecoursecompose2024_i.data.model.UserDTO
import com.mitocode.mitocodecoursecompose2024_i.data.networking.Api
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

//RETROFIT -> API
class LoginRepositoryImp : LoginRepository {
    override suspend fun signIn(email: String, password: String) : Flow<Result<UserDTO>> = flow {
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
                    emit(Result.Success(data = loginResponse.data))
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