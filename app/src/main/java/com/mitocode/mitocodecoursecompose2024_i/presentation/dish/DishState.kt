package com.mitocode.mitocodecoursecompose2024_i.presentation.dish

import com.mitocode.mitocodecoursecompose2024_i.domain.model.Dish

data class DishState(
    val isLoading:Boolean=false,
    val error:String?=null,
    val successfull: List<Dish>? = null
)
