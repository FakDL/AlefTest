package com.example.aleftest.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aleftest.repositories.ImageRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val imageRepository: ImageRepository
): ViewModel(){

    private var _list = MutableLiveData<List<String>>()
    val list: LiveData<List<String>> get() = _list

    fun fetchData(){
        viewModelScope.launch {
            _list.postValue(imageRepository.getImageUrls())
        }
    }

}