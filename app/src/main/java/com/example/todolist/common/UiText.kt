package com.example.todolist.common

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    companion object {
        fun fromThrowable(error: Throwable): UiText {
            return DynamicText(error.localizedMessage ?: error.stackTraceToString())
        }
    }
    class DynamicText(val string: String): UiText()
    class ResourceText(@StringRes val id: Int): UiText()

    @Composable
    fun asText(): String {
        return when(this) {
            is DynamicText -> {
                this.string
            }
            is ResourceText -> {
                stringResource(id = this.id)
            }
        }
    }
}
