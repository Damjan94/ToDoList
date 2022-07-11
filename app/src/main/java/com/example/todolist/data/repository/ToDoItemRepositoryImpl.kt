package com.example.todolist.data.repository

import com.example.todolist.common.MyCoroutineDispatchers
import com.example.todolist.data.source.local.dao.ToDoListDao
import com.example.todolist.domain.model.ToDoItem
import com.example.todolist.domain.repository.ToDoItemRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoItemRepositoryImpl @Inject constructor(
    private val localDataSource: ToDoListDao,
    private val dispatchers: MyCoroutineDispatchers
): ToDoItemRepository {
    override suspend fun getAllToDoItems(): List<ToDoItem> {
        return withContext(dispatchers.io) {localDataSource.getAllToDoItems()}
    }

    override suspend fun addToDoItem(toDoItem: ToDoItem) {
        withContext(dispatchers.io) {localDataSource.addToDoItem(toDoItem)}
    }

    override suspend fun updateToDoItem(toDoItem: ToDoItem) {
        withContext(dispatchers.io) {
            if(localDataSource.doesItemExist(toDoItem.id)) {
                localDataSource.addToDoItem(toDoItem)
            }
        }
    }
}