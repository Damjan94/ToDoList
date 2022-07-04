package com.example.todolist.domain.usecase

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todolist.data.source.local.LocalDatabase
import com.example.todolist.data.source.local.dao.ToDoListDao
import com.example.todolist.domain.model.ToDoItem
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UpdateToDoItemUseCameTest {


    lateinit var dao: ToDoListDao

    @Before
    fun setupTest() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val room = Room.inMemoryDatabaseBuilder(context, LocalDatabase::class.java).build()
        dao = room.getToDoListDao()
    }
    @Test
    fun updateItem() {
        runBlocking {
            val item = ToDoItem(id = 1, "Hello test", false)
            assert(dao.getAllToDoItems().isEmpty())
            dao.addToDoItem(item)
            assert(dao.getAllToDoItems().size == 1)
            val newDoneValue = false
            dao.addToDoItem(item.copy(isDone = newDoneValue))
            assert(dao.getAllToDoItems()[0].isDone == newDoneValue)
        }
    }
}