package com.mitocode.mitocodecoursecompose2024_i.data.repository

import android.content.SharedPreferences
import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.data.database.dao.DishDao
import com.mitocode.mitocodecoursecompose2024_i.data.networking.Api
import com.mitocode.mitocodecoursecompose2024_i.domain.model.Dish
import com.mitocode.mitocodecoursecompose2024_i.domain.model.ToDishEntity
import com.mitocode.mitocodecoursecompose2024_i.domain.model.ToDishList
import com.mitocode.mitocodecoursecompose2024_i.domain.repository.DishRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DishRepositoryImp @Inject constructor(
    val sharedPreferences: SharedPreferences,
    val dishDao: DishDao
) : DishRepository {
    override suspend fun getDishes(): Flow<Result<List<Dish>>> = flow {

        try{
            emit(Result.Loading())
            val token = sharedPreferences.getString("KEY_TOKEN","")
            val response = Api.build().getDishes("Bearer $token")
            if(response.isSuccessful){
                val dishes = response.body()?.data?.ToDishList()
                emit(Result.Success(data = dishes))
            }else{
                emit(Result.Error(message = response.message()))
            }

        }catch (ex: IOException){
            emit(Result.Error(message = "Compruebe su conexión al internet"))
        }
        catch (ex:Exception){
            emit(Result.Error(message = ex.message))
        }


    }

    override suspend fun saveDish(dish: Dish) {
        dishDao.save(dish.ToDishEntity())
    }
}