package com.example.roomdatabase

import androidx.annotation.InspectableProperty.EnumEntry
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class FoodEntry(
  @ColumnInfo(name = "name")var name:String,
  @ColumnInfo(name="price")var price:Int,
  @ColumnInfo(name="rating")var rating:Float
){
  @PrimaryKey(autoGenerate = true)var id:Int=0
}
