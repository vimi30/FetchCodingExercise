package com.example.fetchcodingexercise.repository

import com.example.fetchcodingexercise.model.domain.ListItem
import com.example.fetchcodingexercise.network.NetworkService
import com.example.fetchcodingexercise.utils.Response
import javax.inject.Inject

class Repository @Inject constructor(private val networkService: NetworkService) {
    suspend fun fetchAllItems(): Response<List<ListItem>> {
        return networkService.fetchItemList()
    }
}