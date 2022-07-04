package com.example.todolist.domain.usecase

import com.example.todolist.domain.model.ToDoItem
import com.example.todolist.domain.repository.ToDoItemRepository
import javax.inject.Inject

class PutToDoItemToStorageUseCase @Inject constructor(
    private val repository: ToDoItemRepository
) {
    suspend operator fun invoke(toDoItem: ToDoItem) {
        repository.addToDoItem(toDoItem)
    }
}