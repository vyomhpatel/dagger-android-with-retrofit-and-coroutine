package com.vyom.practice.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.vyom.practice.TestCoroutineRule
import com.vyom.practice.data.WikiApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class SearchRepositoryTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = TestCoroutineRule()

    private val service: WikiApiService = mock()
    private lateinit var repository: SearchRepository

    @Before
    fun setup() {
        repository = SearchRepository(service)
    }

    @Test
    fun test() = runBlockingTest {
        repository.getResult("trump")
        verify(service).hitCountCheckAsync(any(), any(), any(), any())
    }
}