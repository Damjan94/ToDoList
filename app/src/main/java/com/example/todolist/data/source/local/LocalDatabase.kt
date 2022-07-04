package com.example.todolist.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.source.local.dao.ToDoListDao
import com.example.todolist.domain.model.ToDoItem

@Database(entities = [ToDoItem::class], version = 2)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun getToDoListDao(): ToDoListDao
}