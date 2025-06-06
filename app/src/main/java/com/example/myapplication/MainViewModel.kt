package com.example.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _selectedIndex = MutableStateFlow(0)
    val selectedIndex: StateFlow<Int> = _selectedIndex
    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomsheet: StateFlow<Boolean> = _showBottomSheet
    fun onNavItemClicked(index: Int) {

        _selectedIndex.value = index

    }

    fun openBottomsheet() {
        _showBottomSheet.value = true
    }

    fun dismissBottomsheet() {
        _showBottomSheet.value = false
    }
}