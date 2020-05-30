package com.vyom.practice.data

import com.vyom.practice.data.model.Model
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApiService {

    @GET("api.php")
    suspend fun hitCountCheckAsync(
        @Query("action") action: String,
        @Query("format") format: String,
        @Query("list") list: String,
        @Query("srsearch") queryText: String
    ): Model.Data

}