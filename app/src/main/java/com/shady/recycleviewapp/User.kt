package com.shady.recycleviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey
    val id: Int,
    val fName: String,
    val lName: String,
    val score: Int
        )