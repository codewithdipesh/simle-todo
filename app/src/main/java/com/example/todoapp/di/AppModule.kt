package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.TodoDao
import com.example.todoapp.data.local.TodoDatabase
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.Todo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object AppModule {
  //dependecy Injectiopn
    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context : Context) : TodoDatabase{
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "local_db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideTodoDao(db : TodoDatabase):TodoDao = db.todoDao()

    @Provides
    @Singleton
    fun provideTodoRepository(dao : TodoDao) : TodoRepository = TodoRepository(dao = dao)




}