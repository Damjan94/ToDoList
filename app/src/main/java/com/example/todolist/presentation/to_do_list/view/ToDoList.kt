package com.example.todolist.presentation.to_do_list.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist.R
import com.example.todolist.domain.model.ToDoItem
import com.example.todolist.presentation.to_do_list.view_model.ToDoListViewModel

@Composable
fun ToDoList(viewModel: ToDoListViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val errorMessage = viewModel.state.error.asText()
        if(errorMessage.isNotBlank()) {
            Text(text = errorMessage, color = Color.Red)
        }

        if(viewModel.state.isLoading) {
            CircularProgressIndicator()
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AddListAction(viewModel = viewModel)
            Spacer(Modifier.padding(30.dp))
            Text(
                text = stringResource(id = R.string.to_do_list) + ":",
                fontSize = 28.sp
            )
            Spacer(Modifier.padding(15.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                //horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val data = viewModel.state.data
                data?.let {
                    items(it) { item: ToDoItem ->
                        ToDoListItem(item = item, onItemClick = viewModel::onToDoItemClicked)
                        Divider(Modifier.padding(10.dp))
                    }
                }
            }
        }

    }
}

@Composable
// The job of this view is to let the user type in a new item and add it to the list
fun AddListAction(viewModel: ToDoListViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        var text by remember{ mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            singleLine = true
        )
        Button(onClick = {
            viewModel.addToDoItem(text)
            text = ""
        }) {
            Text(text = stringResource(id = R.string.add_list_item))
        }
    }
}