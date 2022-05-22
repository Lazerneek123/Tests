package com.example.appfordisplaying.repository

import com.example.appfordisplaying.view.api.ListService
import com.example.appfordisplaying.view.models.Item
import com.example.appfordisplaying.view.repository.ListRepositoryImpl
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class ListRepositoryImplTest {
    private val listService = mock<ListService>()

    @Test
    fun shouldReturnLoadItemList() {
        val testItemList = listOf(Item(0, "T", "T"))
        Mockito.`when`(listService.getItems()).thenReturn(testItemList)

        val useCase = ListRepositoryImpl(listService)
        val actual = useCase.getItemList()
        val expected = listOf(Item(0, "T", "T"))

        assertEquals(expected, actual)
    }
}