package com.example.todolist.presentation.to_do_list.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.common.Response
import com.example.todolist.common.ViewModelState
import com.example.todolist.domain.model.ToDoItem
import com.example.todolist.domain.usecase.GetAllToDoItemsUseCase
import com.example.todolist.domain.usecase.PutToDoItemToStorageUseCase
import com.example.todolist.domain.usecase.UpdateToDoItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val getAllToDoItemsUseCase: GetAllToDoItemsUseCase,
    private val putToDoItemToStorageUseCase: PutToDoItemToStorageUseCase,
    private val updateToDoItemUseCase: UpdateToDoItemUseCase
): ViewModel() {
    var state by mutableStateOf(ViewModelState<List<ToDoItem>>())
        private set


    init {
        getAllToDoItems()
    }

    private fun getAllToDoItems() {
        getAllToDoItemsUseCase().onEach {
            state = when(it) {
                is Response.Error -> {
                    ViewModelState(error = it.message)
                }
                is Response.Loading -> {
                    ViewModelState(isLoading = true)
                }
                is Response.Success -> {
                    ViewModelState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun addToDoItem(itemText: String) {
        if(itemText.isBlank()) {
            return
        }
        viewModelScope.launch {
            putToDoItemToStorageUseCase(ToDoItem(0, text = itemText, isDone = false))
            getAllToDoItems()
        }
    }

    fun onToDoItemClicked(item: ToDoItem) {
        viewModelScope.launch {
            val newItem = ToDoItem(id = item.id, text = item.text, isDone = !item.isDone)
            updateToDoItemUseCase(newItem)
            getAllToDoItems()// poll the database for changes
        }
    }
}