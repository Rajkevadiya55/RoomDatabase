package com.example.roomdatabase.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.FoodDao
import com.example.roomdatabase.FoodEntry

@Database(entities = [FoodEntry::class], version = 1)
abstract class RoomDB:RoomDatabase(){

    companion object{

        fun getInstance(context: Context):RoomDB{
            var db= Room.databaseBuilder(context,RoomDB::class.java,"Hotel")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }
    }

    abstract fun foods():FoodDao
}
