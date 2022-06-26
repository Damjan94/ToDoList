package com.example.todolist.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todolist.model.ToDoItem

class ListItemsViewModel(): ViewModel() {

    private var _listItems = mutableStateListOf<ToDoItem>()

    val listItems = _listItems

}