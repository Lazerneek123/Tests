package com.example.appfordisplaying.viewModels

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.example.appfordisplaying.view.models.Item
import com.example.appfordisplaying.view.repository.ListUseCase
import com.example.appfordisplaying.view.viewModels.FragmentViewModel
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class FragmentViewModelTest {
    private val listUseCase = mock<ListUseCase>()

    @After
    fun afterEach() {
        Mockito.reset(listUseCase)
        ArchTaskExecutor.getInstance().setDelegate(null)

    }

    @Before
    fun beforeEach() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }
        })
    }

    @Test
    fun shouldReturnCorrectListItem() {
        val saveResult = listOf(Item(0, "Test", "Test"))
        Mockito.`when`(listUseCase.loadItemList()).thenReturn(saveResult)

        val viewModel = FragmentViewModel(listUseCase)
        viewModel.loadItemList()

        val expected = listOf(Item(0, "Test", "Test"))
        val actual = viewModel.itemList.value

        assertEquals(expected, actual)
    }

    @Test
    fun shouldReturnCorrectTitle() {
        val testItemTitle = "Should return correct title!"
        Mockito.`when`(listUseCase.getItemTitle()).thenReturn(testItemTitle)

        val viewModel = FragmentViewModel(listUseCase)
        viewModel.getTitleItem()

        val expected = "Should return correct title!"
        val actual = viewModel.itemTitle.value

        assertEquals(expected, actual)
    }
}