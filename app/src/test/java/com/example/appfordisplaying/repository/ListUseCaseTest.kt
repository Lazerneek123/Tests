package com.example.appfordisplaying.repository

import com.example.appfordisplaying.view.models.Item
import com.example.appfordisplaying.view.repository.ListRepository
import com.example.appfordisplaying.view.repository.ListUseCase
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class ListUseCaseTest {
    private val listRepository = mock<ListRepository>()

    @Test
    fun shouldReturnLoadItemList() {
        val testItemList = listOf(Item(0, "T", "T"))
        Mockito.`when`(listRepository.getItemList()).thenReturn(testItemList)

        val useCase = ListUseCase(listRepository)
        val actual = useCase.loadItemList()
        val expected = listOf(Item(0, "T", "T"))

        assertEquals(expected, actual)
    }
}