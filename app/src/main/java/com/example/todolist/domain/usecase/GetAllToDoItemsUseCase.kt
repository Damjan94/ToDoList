package com.example.todolist.domain.usecase

import com.example.todolist.common.Response
import com.example.todolist.common.UiText
import com.example.todolist.domain.model.ToDoItem
import com.example.todolist.domain.repository.ToDoItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllToDoItemsUseCase @Inject constructor(
    private val repository: ToDoItemRepository
){
    operator fun invoke(): Flow<Response<List<ToDoItem>>> = flow{
        emit(Response.Loading())
        emit(Response.Success(repository.getAllToDoItems()))
    }.catch { error ->
        emit(Response.Error(UiText.fromThrowable(error)))
    }
}