package com.example.gomnakon4.data.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gomnakon4.data.model.Thing

@Dao
interface ThingDao {

    @Insert
    suspend fun insert(thing : Thing)

    @Query("SELECT * FROM things")
    suspend fun getAllThings() : List<Thing>

}