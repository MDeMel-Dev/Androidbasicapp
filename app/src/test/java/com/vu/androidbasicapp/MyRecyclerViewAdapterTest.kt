package com.vu.androidbasicapp

import com.vu.androidbasicapp.home.data.ResponseItem
import com.vu.androidbasicapp.home.ui.recyclerview.MyRecyclerViewAdapter
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MyRecyclerViewAdapterTest {

    private lateinit var adapter: MyRecyclerViewAdapter
    private val mockNavigationFunction: (ResponseItem) -> Unit = {}
    private val exampleResponseItem = ResponseItem(id = "1", objectName = "xyz", dataSection = mapOf("key1" to "value"))

    @Before
    fun setUp() {
        adapter = spyk(MyRecyclerViewAdapter(navigationFunction = mockNavigationFunction))
        every { adapter.notifyDataSetChanged() } returns Unit
    }

    @Test
    fun `getItemCount returns correct size`() {
        // Given
        val dataList = mutableListOf(
            exampleResponseItem,
            exampleResponseItem.copy(id = "2"),
            exampleResponseItem.copy(id = "3", objectName = "abc")
        )
        adapter.setData(dataList)

        // When
        val itemCount = adapter.getItemCount()

        // Then
        assertEquals(3, itemCount)
    }

    @Test
    fun `setData updates dataList and calls notifyDataSetChanged`() {
        // Given
        val newDataList = listOf(
            exampleResponseItem.copy(id = "4"),
            exampleResponseItem.copy(id = "5", objectName = "abcd")
        )

        // When
        adapter.setData(newDataList)

        // Then
        assertEquals(2, adapter.getItemCount()) // Verify dataList size is updated
        verify { adapter.notifyDataSetChanged() } // Verify notifyDataSetChanged is called
    }
}