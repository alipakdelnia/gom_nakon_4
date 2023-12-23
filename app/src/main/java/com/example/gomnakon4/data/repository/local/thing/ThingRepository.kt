package com.example.gomnakon4.data.repository.local.thing

import com.example.gomnakon4.data.database.AppDatabase
import com.example.gomnakon4.data.model.Thing

interface ThingRepository {

fun addThing(thing: Thing)

fun saveThingsToDatabase(database: AppDatabase, thingName: String, category: String, whereIsIt: String)

fun getThings(): List<Thing>

}