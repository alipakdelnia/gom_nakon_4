package com.example.gomnakon4.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "things")
data class Thing(

    @PrimaryKey (autoGenerate = true)
    val id : Long = 0,

    val name : String,
    val category : String,
    val locate : String
)
