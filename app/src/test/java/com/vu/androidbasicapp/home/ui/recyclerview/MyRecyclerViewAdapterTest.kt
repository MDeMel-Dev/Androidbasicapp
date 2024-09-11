package com.vu.androidbasicapp.home.ui.recyclerview

import com.vu.androidbasicapp.home.data.ResponseItem
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class MyRecyclerViewAdapterTest {
    val exampleResponseItem = ResponseItem(id = "1", objectName = "sdfhvsdjh", dataSection = mapOf("key1" to "value"))
    val data = listOf(exampleResponseItem, exampleResponseItem.copy(id = "2"), exampleResponseItem.copy(id = "3"))
    private lateinit var adapter: MyRecyclerViewAdapter

    @Before
    fun setup() {
        adapter = spyk(MyRecyclerViewAdapter(navigationFunction = {}))
        every { adapter.notifyDataSetChanged() } returns Unit
    }

    @Test
    fun `adapter getitemCount() returns the correct item count`() {
        adapter.setData(data)
        val result = adapter.getItemCount()

        assertEquals(3, result)
    }

    @Test
    fun `adapter setData() calls notifyDataSetChanged() when it's given new data`() {
        // When
        adapter.setData(data)

        // Then
        verify { adapter.notifyDataSetChanged() }
    }

    @Test
    fun `notifyDataSetChanged() is called everytime new data is set to the adapter`() {
        // Given
        val newDataList = listOf(exampleResponseItem, exampleResponseItem.copy(id = "4"), exampleResponseItem.copy(id = "5"))

        // When
        adapter.setData(data)
        adapter.setData(newDataList)

        // Then
        verify(exactly = 2) { adapter.notifyDataSetChanged() }
    }
}