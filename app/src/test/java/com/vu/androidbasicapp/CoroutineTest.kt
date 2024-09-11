package com.vu.androidbasicapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CoroutineTest {

    @Test
    fun testCoroutineExecution(): Unit = runTest { // same as runTest(StandardDispatcher)
        var result = ""
        launch { result = "Hello " }
        launch { result += "world" }

        advanceUntilIdle()

        assertEquals ("Hello world", result)
    }

    @Test
    fun testCoroutineExecutionWithUnconfinedTestDispatcher(): Unit = runTest(UnconfinedTestDispatcher()) {

        var result = ""
        launch { result = "Hello " }
        launch { result += "world" } // Coroutines executed one after the other because UnconfinedTestDispatcher lets coroutines run immediately.

        assertEquals ("Hello world", result)
    }

    @Test
    fun testCoroutineExecutionWithUnconfinedTestDispatcherWithDelays(): Unit = runTest(UnconfinedTestDispatcher()) {

        var result = ""
        launch {
            delay(2000)
            result = "Hello "
        } // although this coroutine executes eagerly, the completion of the coroutine is not guaranteed

        advanceUntilIdle() // make sure previous coroutine has finished execution

        launch { result += "world" }

        assertEquals ("Hello world", result)
    }
}