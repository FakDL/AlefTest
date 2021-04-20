package com.example.aleftest.network

import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ImageService {
    @GET("task-m-001/list.php")
    suspend fun getImageUrls(): List<String>
}