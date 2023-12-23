package com.example.gomnakon4.data.repository.local.thing

import android.content.SharedPreferences
import com.example.gomnakon4.data.database.AppDatabase
import com.example.gomnakon4.data.model.Thing

class ThingRepositoryImpl(
private val sharedPreferences: SharedPreferences
): ThingRepository {

    override fun addThing(thing: Thing) {


    }

    override fun saveThingsToDatabase(
        database: AppDatabase,
        thingName: String,
        category: String,
        whereIsIt: String
    ) {


    }

    override fun getThings(): List<Thing> {


    }
}