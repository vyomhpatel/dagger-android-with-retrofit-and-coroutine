package com.vyom.practice.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.vyom.practice.TestCoroutineRule
import com.vyom.practice.data.WikiApiService
import com.vyom.practice.data.model.Model
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class SearchActivityViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = TestCoroutineRule()

    private val mockRepo: SearchRepository = mock()
    private val mockService: WikiApiService = mock()
    private lateinit var viewModel: SearchActivityViewModel

    @Before
    fun setupViewModel() {
        viewModel = SearchActivityViewModel(mockRepo)
    }

    @Test
    fun test() = runBlockingTest {
        val data = Model.Data(Model.Query(Model.SearchInfo(100)))
        mockRepo.service = mockService
        whenever(mockRepo.getResult("trump")).doReturn(data)
        viewModel.getResponse("trump").observeForever {
            assertEquals(data, it.getOrNull())
        }
    }
}