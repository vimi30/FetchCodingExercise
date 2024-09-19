package com.example.fetchcodingexercise.model.remote

import com.example.fetchcodingexercise.model.domain.ListItem
import kotlinx.serialization.Serializable

@Serializable
data class ListItemRemote(
    val id: Int,
    val listId: Int,
    val name: String?
)



fun ListItemRemote.toListItemDomain(): ListItem {
    return ListItem(
        id = id,
        listId = listId,
        name = name!!
    )
}