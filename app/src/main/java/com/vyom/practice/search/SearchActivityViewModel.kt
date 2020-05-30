package com.vyom.practice.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class SearchActivityViewModel @Inject constructor(private val repo: SearchRepository) : ViewModel() {

    fun getResponse(searchTerm: String) =
        repo.getResult(searchTerm, viewModelScope.coroutineContext + Dispatchers.IO)

}