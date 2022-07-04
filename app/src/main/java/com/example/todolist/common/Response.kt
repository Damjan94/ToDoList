package com.example.todolist.common

sealed class Response<T>(
    val message: UiText = UiText.DynamicText(""),
    val data: T? = null
    ) {
    class Error<T>(message: UiText): Response<T>(message = message)
    class Loading<T>(): Response<T>()
    class Success<T>(data: T): Response<T>(data = data)

}
