package com.vu.androidbasicapp

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineTest {

    @Test
    fun testCoroutineExecution() = runTest(UnconfinedTestDispatcher()) {
        var result = ""

        launch {
            result = "Hello "
            delay(1000)
        }

        launch {
            result += "world"
            delay(1000)
        }

        assertEquals("Hello world", result)
    }
}
