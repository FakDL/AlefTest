package com.example.aleftest.repositories

import android.util.Log
import com.example.aleftest.network.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val imageService: ImageService
) {
    suspend fun getImageUrls(): List<String> {
        val list = imageService.getImageUrls()
        Log.d("Test", list.toString())
        return list
    }
}