package com.example.fetchcodingexercise.network

import com.example.fetchcodingexercise.model.domain.ListItem
import com.example.fetchcodingexercise.model.remote.ListItemRemote
import com.example.fetchcodingexercise.model.remote.toListItemDomain
import com.example.fetchcodingexercise.utils.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class NetworkService @Inject constructor(private val httpClient: HttpClient) {

    suspend fun fetchItemList(): Response<List<ListItem>> {
        return safeNetworkCall {
            httpClient.get("hiring.json")
                .body<List<ListItemRemote>>()
                .filter { !it.name.isNullOrEmpty() }
                .map { it.toListItemDomain() }
        }
    }

    private inline fun <T> safeNetworkCall(apiCall: () -> T): Response<T> {
        return try {
            Response.Success(data = apiCall())
        } catch (e: Exception) {
            Response.Failure(exception = e)
        }
    }
}