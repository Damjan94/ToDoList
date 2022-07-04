package com.example.todolist.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todolist.domain.model.ToDoItem

@Dao
interface ToDoListDao {

    @Query("SELECT * FROM ToDoItem")
    suspend fun getAllToDoItems(): List<ToDoItem>

    //@Query("SELECT COUNT(*) WHERE id IS :itemId")
    @Query("SELECT COUNT(*) FROM ToDoItem WHERE id IS :itemId")
    suspend fun doesItemExist(itemId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToDoItem(item: ToDoItem)
}
