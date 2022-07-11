package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import com.example.todolist.common.MyCoroutineDispatchers
import com.example.todolist.data.repository.ToDoItemRepositoryImpl
import com.example.todolist.data.source.local.LocalDatabase
import com.example.todolist.data.source.local.dao.ToDoListDao
import com.example.todolist.domain.repository.ToDoItemRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext appContext: Context): LocalDatabase {
        return Room.databaseBuilder(
            appContext,
            LocalDatabase::class.java,
            "my_cool_new_database").build()
    }
    @Provides
    @Singleton
    fun provideToDoDao(localDatabase: LocalDatabase): ToDoListDao {
        return localDatabase.getToDoListDao()
    }

    @Provides
    @Singleton
    fun provideMyCoroutineDispatchers(): MyCoroutineDispatchers {
        return MyCoroutineDispatchers()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun bindToDoItemRepository(repo: ToDoItemRepositoryImpl): ToDoItemRepository

    }

}