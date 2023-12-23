package com.example.gomnakon4.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gomnakon4.data.database.Dao.ThingDao
import com.example.gomnakon4.data.model.Thing

@Database (entities = [Thing::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun thingDao(): ThingDao
}