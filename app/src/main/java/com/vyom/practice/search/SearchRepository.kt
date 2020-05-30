package com.vyom.practice.search

import androidx.annotation.VisibleForTesting
import com.vyom.practice.data.WikiApiService
import com.vyom.practice.data.model.Model
import javax.inject.Inject

open class SearchRepository @Inject constructor(@VisibleForTesting var service: WikiApiService) {

    suspend fun getResult(searchTerm: String): Model.Data {
        return service.hitCountCheckAsync("query", "json", "search", searchTerm)
    }
}