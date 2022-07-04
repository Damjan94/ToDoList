package com.example.todolist.common

data class ViewModelState<T>(
    val isLoading: Boolean = false,
    val error: UiText = UiText.DynamicText(""),
    val data: T? = null
)