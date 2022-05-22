package com.example.appfordisplaying.view.repository

import com.example.appfordisplaying.view.api.ListService
import com.example.appfordisplaying.view.models.Item

class ListRepositoryImpl(private val listService: ListService) : ListRepository {
    override /*suspend*/ fun getItemList() = listService.getItems()
}