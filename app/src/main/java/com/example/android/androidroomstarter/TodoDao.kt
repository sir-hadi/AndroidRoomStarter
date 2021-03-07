package com.example.android.androidroomstarter

import androidx.room.*
import com.example.android.androidroomstarter.entities.Task

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Query("SELECT * FROM Task")
    fun getAll(): List<Task>

    @Delete
    fun delete(task: Task)
}