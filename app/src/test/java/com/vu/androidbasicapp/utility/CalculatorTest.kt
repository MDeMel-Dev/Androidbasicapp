package com.vu.androidbasicapp.utility

import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator
    private val mockLogger: Logger = mockk(relaxed = true)

    @Before
    fun setUp() {
        // Initialize the Calculator with a mocked Logger
        calculator = Calculator(mockLogger)
    }

    @Test
    fun `add should return correct result and log the operation`() {
        // Given
        val a = 5
        val b = 3

        // When
        val result = calculator.add(a, b)

        // Then
        assertEquals(8, result)

        // Verify the result is correct
        verify { mockLogger.log("Adding 5 and 3: 8") } // Verify the log message
    }

    @Test fun `subtract should return correct result and log the operation`() {
        // Given
        val a = 10
        val b = 4

        // When
        val result = calculator.subtract(a, b)

        // Then
        assertEquals(6, result)

        // Verify the result is correct
        verify { mockLogger.log("Subtracting 10 and 4: 6") } // Verify the log message
    }
}
