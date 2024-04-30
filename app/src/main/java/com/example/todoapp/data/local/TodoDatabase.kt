package com.example.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.TodoDao
import com.example.todoapp.domain.model.Todo


@Database(entities =[ Todo::class] , version = 1, exportSchema = true)
abstract class TodoDatabase:RoomDatabase() {
    abstract fun todoDao() : TodoDao
}