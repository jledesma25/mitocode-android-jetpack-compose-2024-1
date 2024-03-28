package com.mitocode.mitocodecoursecompose2024_i.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mitocode.mitocodecoursecompose2024_i.data.database.dao.DishDao
import com.mitocode.mitocodecoursecompose2024_i.data.database.model.DishEntity

@Database(entities = [DishEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //Daos
    abstract fun dishDao() : DishDao

}