package com.vu.androidbasicapp.home.ui

import android.util.Log
import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.data.RestfulApiDevRepositoryClass
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeScreenViewModelTest {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var repository: RestfulApiDevRepositoryClass
    private val exampleResponseItem = ResponseItem(id = "1", objectName = "xyz", dataSection = mapOf("key1" to "value"))

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        // Mock the repository
        repository = mockk()

        // Set the dispatcher for the ViewModel's scope
        Dispatchers.setMain(testDispatcher)

        // Mock the repository response
        coEvery { repository.getAllObjectsData() } returns listOf(
            exampleResponseItem.copy(id = "Item 1"),
            exampleResponseItem.copy(id ="Item 2")
        )

        // Mock the Log class - this is required because we call Log.d("nit3213", "HomeScreenViewModel ViewModel injected ") in the init method
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0

        // Initialize the ViewModel
        viewModel = HomeScreenViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher to the original one
    }

    @Test
    fun `test ViewModel calls API and updates StateFlow on init`() = runTest(testDispatcher) {
        // The ViewModel's init() method is called during setup @Before when after viewmodel is created

        // Advance time to allow the ViewModel's coroutine to execute
        advanceUntilIdle()

        // Verify that the greetingText is updated
        assertEquals("Api has responded with the following items", viewModel.greetingText.value)

        // Verify that the apiResponseObjects is updated with the mocked data
        val apiResponse = viewModel.apiResponseObjects.value
        assertEquals(2, apiResponse.size)
        assertEquals("Item 1", apiResponse[0].id)
        assertEquals("Item 2", apiResponse[1].id)
    }
}