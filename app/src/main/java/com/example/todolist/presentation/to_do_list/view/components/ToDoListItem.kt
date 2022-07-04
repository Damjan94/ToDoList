package com.example.todolist.presentation.to_do_list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.todolist.domain.model.ToDoItem

@Composable
fun ToDoListItem(item: ToDoItem, onItemClick: (ToDoItem) -> Unit) {
    Text(
        text = item.text,
        modifier = Modifier.fillMaxWidth().clickable { onItemClick(item) },
        textAlign = TextAlign.Center,
        style = if (item.isDone) TextStyle(textDecoration = TextDecoration.LineThrough) else LocalTextStyle.current
        )
}