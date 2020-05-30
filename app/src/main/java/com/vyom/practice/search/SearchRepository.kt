package com.vyom.practice.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.vyom.practice.data.WikiApiService
import com.vyom.practice.data.model.Model
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SearchRepository @Inject constructor(private val service: WikiApiService) {

    fun getResult(searchTerm: String, context: CoroutineContext): LiveData<Result<Model.Data>> {
        return liveData(context) {
            try {
                val data = service.hitCountCheckAsync("query", "json", "search", searchTerm)
                emit(Result.success(data))
            } catch (t: Throwable) {
                emit(Result.failure<Model.Data>(t))
            }
        }
    }
}