package com.example.appfordisplaying.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfordisplaying.view.models.Item
import com.example.appfordisplaying.view.repository.ListUseCase

class FragmentViewModel(private val listUseCase: ListUseCase) : ViewModel() {

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    private val _itemTitle = MutableLiveData<String>()
    val itemTitle: LiveData<String> = _itemTitle

    fun loadItemList() {
        //viewModelScope.launch {
        try {
            _itemList.value = listUseCase.loadItemList()
        } catch (e: Exception) {
            _itemList.value = listOf(Item(0, "${e.message}", ""))
        }
        //}
    }

    //For example test
    fun getTitleItem() {
        _itemTitle.value = listUseCase.getItemTitle()
    }
}