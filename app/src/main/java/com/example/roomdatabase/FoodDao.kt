package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {

    @Insert
    fun addFood(food:FoodEntry)

    @Query("SELECT * FROM food")
    fun getFood():List<FoodEntry>

 @Delete
 fun deleteFood(food: FoodEntry)
}