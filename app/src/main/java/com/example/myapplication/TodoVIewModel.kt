package com.example.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.reftrofit.DataModel
import com.example.myapplication.reftrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val _todoList = MutableStateFlow<List<DataModel>>(emptyList())
    val todoList: StateFlow<List<DataModel>> = _todoList
    val todoLiveData = todoList.asLiveData()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                val todos = RetrofitInstance.getApiServices().getItems()
                Log.d("TodoViewModel", "Fetched todos: $todos")
                _todoList.value = todos
            } catch (e: Exception) {
                println("Error fetching todos: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}