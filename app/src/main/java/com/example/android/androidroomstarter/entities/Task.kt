package com.example.android.androidroomstarter.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val id: Int,
    val taskName: String,
    val done:Boolean
)