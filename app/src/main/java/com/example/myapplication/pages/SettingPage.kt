package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.MainViewModel

@Composable
fun SettingPage(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFC8C8D0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                viewModel.openBottomsheet()
            }
        ) {
            Text(text = "Click her to open Bottom sheet")
        }
    }
}

