package com.example.android5.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android5.FoodDao
import com.example.android5.FoodEntity

@Database(entities = [FoodEntity::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    companion object {
        fun getInstance(context: Context): RoomDB {
            var db = Room.databaseBuilder(context, RoomDB::class.java, "Hotel")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }
    }

    abstract fun foods() : FoodDao

}