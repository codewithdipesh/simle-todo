package com.example.todoapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TodoRepository
): ViewModel() {

    var todo by mutableStateOf(Todo(0,"",false))
        private set

    val allTodos: Flow<List<Todo>> = flow {
        repository.getAllTodos().collect{
         emit(it)
    } }

    private var deletedTodos : Todo ? = null

    fun insertTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertTodo(todo = todo)
        }
    }
    fun updateTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTodo(todo = todo)
        }
    }
    fun deleteTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            deletedTodos = todo
             repository.deleteTodo(todo=todo)
        }
    }

    fun undoDeletedTodo() {
        deletedTodos?.let {
            viewModelScope.launch(Dispatchers.IO){
                repository.insertTodo(todo = todo)
            }
        }
    }

    fun getTodoById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            todo = repository.getTodoById(id = id)
        }
    }

    fun updateTask(newValue : String){
       todo = todo.copy(task = newValue)
    }

    fun toggleImportant(){
        todo =todo.copy(isImportant =  !todo.isImportant)
    }


}