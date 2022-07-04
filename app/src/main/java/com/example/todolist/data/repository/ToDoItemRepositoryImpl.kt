package com.example.todolist.data.repository

import com.example.todolist.data.source.local.dao.ToDoListDao
import com.example.todolist.domain.model.ToDoItem
import com.example.todolist.domain.repository.ToDoItemRepository
import javax.inject.Inject

class ToDoItemRepositoryImpl @Inject constructor(
    private val localDataSource: ToDoListDao
): ToDoItemRepository {
    override suspend fun getAllToDoItems(): List<ToDoItem> {
        return localDataSource.getAllToDoItems()
    }

    override suspend fun addToDoItem(toDoItem: ToDoItem) {
        localDataSource.addToDoItem(toDoItem)
    }

    override suspend fun updateToDoItem(toDoItem: ToDoItem) {
        if(localDataSource.doesItemExist(toDoItem.id)) {
            localDataSource.addToDoItem(toDoItem)
        }
    }
}