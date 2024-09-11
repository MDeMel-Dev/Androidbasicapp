package com.vu.androidbasicapp.home.ui.recyclerview

import com.vu.androidbasicapp.home.data.ResponseItem
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import io.mockk.verifyCount
import org.junit.Assert.assertEquals
import org.junit.Test


class MyRecyclerViewAdapterTest {

    @Test
    fun `adapter getitemCount() returns the correct item count`() {
        val exampleResponseItem = ResponseItem(id = "1", objectName = "sdfhvsdjh", dataSection = mapOf("key1" to "value"))
        val data = listOf(exampleResponseItem, exampleResponseItem.copy(id = "2"), exampleResponseItem.copy(id = "3"))
        val adapter = spyk(MyRecyclerViewAdapter(navigationFunction = {}))
        every { adapter.notifyDataSetChanged() } returns Unit


        adapter.setData(data)
        val result = adapter.getItemCount()

        assertEquals(3, result)
    }

    @Test
    fun `adapter setData() calls notifyDataSetChanged() when it's given new data`() {
        val exampleResponseItem = ResponseItem(id = "1", objectName = "sdfhvsdjh", dataSection = mapOf("key1" to "value"))
        val data = listOf(exampleResponseItem, exampleResponseItem.copy(id = "2"), exampleResponseItem.copy(id = "3"))
        val adapter = spyk(MyRecyclerViewAdapter(navigationFunction = {}))
        every { adapter.notifyDataSetChanged() } returns Unit

        adapter.setData(data)

        verify { adapter.notifyDataSetChanged() }
    }

    @Test
    fun `notifyDataSetChanged() is called everytime new data is set to the adapter`() {
        val exampleResponseItem = ResponseItem(id = "1", objectName = "sdfhvsdjh", dataSection = mapOf("key1" to "value"))
        val data = listOf(exampleResponseItem, exampleResponseItem.copy(id = "2"), exampleResponseItem.copy(id = "3"))
        val newDataList = listOf(exampleResponseItem, exampleResponseItem.copy(id = "4"), exampleResponseItem.copy(id = "5"))
        val adapter = spyk(MyRecyclerViewAdapter(navigationFunction = {}))
        every { adapter.notifyDataSetChanged() } returns Unit

        adapter.setData(data)
        adapter.setData(newDataList)

        verify(exactly = 2) { adapter.notifyDataSetChanged() }
    }
}