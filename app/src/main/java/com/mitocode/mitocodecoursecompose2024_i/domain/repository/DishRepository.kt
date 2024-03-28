package com.mitocode.mitocodecoursecompose2024_i.domain.repository

import com.mitocode.mitocodecoursecompose2024_i.core.Result
import com.mitocode.mitocodecoursecompose2024_i.domain.model.Dish
import kotlinx.coroutines.flow.Flow

interface DishRepository {

    suspend fun getDishes() : Flow<Result<List<Dish>>>

    suspend fun saveDish(dish:Dish)

}