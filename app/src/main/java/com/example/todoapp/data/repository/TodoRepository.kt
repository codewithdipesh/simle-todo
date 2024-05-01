package com.example.todoapp.data.repository
import com.example.todoapp.data.TodoDao
import com.example.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(
    private val dao: TodoDao
){
    suspend fun  insertTodo(todo :Todo) = dao.insertTodo(todo = todo)

    suspend fun  updateTodo(todo :Todo) = dao.updateTodo(todo = todo )

    suspend fun  deleteTodo(todo :Todo) = dao.deleteTodo(todo = todo )

    suspend fun  getTodoById(id :Int) = dao.getTodoById(id = id  )

    suspend fun getAllTodos():Flow<List<Todo>> = dao.getAllTodos()


}