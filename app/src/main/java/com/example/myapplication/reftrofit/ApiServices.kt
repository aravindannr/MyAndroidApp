package com.example.myapplication.reftrofit

import retrofit2.http.GET

interface ApiServices {
    @GET("todos")
    suspend fun getItems(): List<DataModel>
}