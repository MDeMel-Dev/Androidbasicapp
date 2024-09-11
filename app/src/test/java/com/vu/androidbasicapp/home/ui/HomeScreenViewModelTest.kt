package com.vu.androidbasicapp.home.ui

import android.util.Log
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeScreenViewModelTest {

    private lateinit var viewModel: HomeScreenViewModel
    val exampleResponseItem =
        ResponseItem(id = "1", objectName = "sdfhvsdjh", dataSection = mapOf("key1" to "value"))
    private val data = listOf(
        exampleResponseItem,
        exampleResponseItem.copy(id = "2"),
        exampleResponseItem.copy(id = "3")
    )

    val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        mockkStatic(Log::class)
        coEvery { Log.d(any(), any()) } returns 0

        val repository: RestfulApiDevRepositoryClass = mockk(relaxed = true)
        coEvery { repository.getAllObjectsData() } returns data

        viewModel = HomeScreenViewModel(repository) // init() method is called here
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher to the original one
    }


    @Test
    fun `ViewModel gets the api result when it is initialized`() = runTest(testDispatcher) {
        advanceUntilIdle()

        assertEquals(data.first(), viewModel.apiResponseObjects.value.first())
    }

    @Test
    fun `The updateGreetingText method works correctly`() = runTest(testDispatcher) {
        advanceUntilIdle()

        assertEquals("Api has responded with the following items", viewModel.greetingText.value)
    }
}