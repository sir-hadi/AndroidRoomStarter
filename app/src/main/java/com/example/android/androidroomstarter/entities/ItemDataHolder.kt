package com.example.android.androidroomstarter.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemDataHolder(var imageResource: Int, @PrimaryKey var text:String, var checkStatus:Boolean)