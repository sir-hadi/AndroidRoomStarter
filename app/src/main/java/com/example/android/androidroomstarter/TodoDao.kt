package com.example.android.androidroomstarter

import androidx.room.*
import com.example.android.androidroomstarter.entities.ItemDataHolder
import com.example.android.androidroomstarter.entities.Task

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task: ItemDataHolder)

    @Query("SELECT * FROM ItemDataHolder")
    fun getAll(): List<ItemDataHolder>

//    @Query("SELECT MAX(id) FROM Task")
//    fun getLastId(): Int

    @Query("SELECT checkStatus FROM ItemDataHolder WHERE text = :itemName")
    fun isCheck(itemName: String): Boolean

    @Delete
    fun delete(task: ItemDataHolder)

    @Query("UPDATE ItemDataHolder SET checkStatus = :done WHERE text = :taskName")
    fun updateDone(taskName: String, done: Boolean)


}