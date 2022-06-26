package com.example.todolist.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.R
import com.example.todolist.model.ToDoItem
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.viewmodel.ListItemsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {


                }
            }
        }
    }
}

@Composable
fun MainView() {
    ToDoList()
}

@Composable
fun ToDoList() {
    ListHeader()
    ListItems()
    ListFooter()
}

@Composable
fun ListHeader() {
    Text(text = stringResource(id = R.string.my_todo_list))
}

@Composable
fun ListItems(list: SnapshotStateList<ToDoItem>) {

    LazyColumn() {
        items(list) { todoItem ->
            ToDoListItem(todoItem)
        }
    }
    
}

@Composable
fun ListFooter() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = stringResource(id = R.string.add_list_item))
    }
}