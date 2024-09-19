package com.example.fetchcodingexercise.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fetchcodingexercise.R
import com.example.fetchcodingexercise.model.domain.ListItem
import com.example.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

@Composable
fun ListItemComponent(item: ListItem) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(8.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ListItemDataComponent(
                header = stringResource(R.string.item_name_header),
                value = item.name
            )
            ListItemDataComponent(
                header = stringResource(R.string.item_id_header),
                value = item.id.toString()
            )
            ListItemDataComponent(
                header = stringResource(R.string.list_id_header),
                value = item.listId.toString()
            )
        }

    }
}

@Preview
@Composable
fun ListItemComponentPreview() {
    FetchCodingExerciseTheme {
        ListItemComponent(
            item = ListItem(
                id = 12,
                name = "List 2",
                listId = 2
            )
        )
    }
}