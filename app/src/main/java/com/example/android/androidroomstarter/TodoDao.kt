package com.example.android.androidroomstarter

import androidx.room.*
import com.example.android.androidroomstarter.entities.Task

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task: Task)

    @Query("SELECT * FROM Task")
    fun getAll(): List<Task>

    @Query("SELECT MAX(id) FROM Task")
    fun getLastId(): Int

    @Delete
    fun delete(task: Task)

    @Query("UPDATE Task SET done = :done WHERE taskName = :taskName")
    fun updateDone(taskName: String, done: Boolean)


}