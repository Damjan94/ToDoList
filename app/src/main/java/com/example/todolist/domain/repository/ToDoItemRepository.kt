package com.example.todolist.domain.repository

import com.example.todolist.domain.model.ToDoItem

interface ToDoItemRepository {
    suspend fun getAllToDoItems(): List<ToDoItem>
    suspend fun addToDoItem(toDoItem: ToDoItem)
    suspend fun updateToDoItem(toDoItem: ToDoItem)
}