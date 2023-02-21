package com.example.android5

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {

    @Insert
    fun addFood(food : FoodEntity)

    @Query("SELECT * FROM food")
    fun getFood() : List<FoodEntity>

}