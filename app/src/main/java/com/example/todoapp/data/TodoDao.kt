package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlin.collections.List

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo:Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id:Int):Todo

    @Query("SELECT * FROM Todo")
    suspend fun getAllTodos(): Flow<List<Todo>>

}