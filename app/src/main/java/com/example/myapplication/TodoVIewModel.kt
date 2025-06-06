package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.reftrofit.DataModel
import com.example.myapplication.reftrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoVIewModel : ViewModel() {
    private val _todoList = MutableStateFlow<List<DataModel>>(emptyList())
    val todoList: StateFlow<List<DataModel>> = _todoList

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                val todos = RetrofitInstance.getApiServices().getItems()
                _todoList.value = todos
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}