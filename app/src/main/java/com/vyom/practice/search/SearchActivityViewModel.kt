package com.vyom.practice.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vyom.practice.data.model.Model
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class SearchActivityViewModel @Inject constructor(private val repo: SearchRepository) :
    ViewModel() {

    fun getResponse(searchTerm: String): LiveData<Result<Model.Data>> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            try {
                emit(Result.success(repo.getData(searchTerm)))
            } catch (t: Throwable) {
                emit(Result.failure<Model.Data>(t))
            }
        }
    }


}

