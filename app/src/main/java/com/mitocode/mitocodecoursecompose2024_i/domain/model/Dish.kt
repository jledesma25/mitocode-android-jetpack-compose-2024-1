package com.mitocode.mitocodecoursecompose2024_i.domain.model

import com.mitocode.mitocodecoursecompose2024_i.data.database.model.DishEntity
import com.mitocode.mitocodecoursecompose2024_i.data.networking.model.DishDTO

data class Dish(
    val id:Int,
    val name:String,
    val description:String,
    val thumbails:String,
    val image:String,
    val carbohydrates:Double,
    val proteins:Double,
    val price:Double,
    val rating:Double,
    val ingredients:String,
    val flagHeader:Boolean
)

fun List<DishDTO>.ToDishList() : List<Dish> = map {
    Dish(
        id = it.id,
        name = it.name,
        description = it.description,
        thumbails = it.thumbails,
        image = it.image,
        carbohydrates = it.carbohydrates,
        proteins = it.proteins,
        price = it.price,
        rating = it.rating,
        ingredients = it.ingredients,
        flagHeader = it.flagHeader
    )
}

fun Dish.ToDishEntity() : DishEntity{
    return DishEntity(
        id = id,
        name = name,
        description = description,
        thumbails = thumbails,
        image = image,
        carbohydrates = carbohydrates,
        proteins = proteins,
        price = price,
        rating = rating,
        ingredients = ingredients,
        flagHeader = flagHeader,
        flag = true
    )
}

