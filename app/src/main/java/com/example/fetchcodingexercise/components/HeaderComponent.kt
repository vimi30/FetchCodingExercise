package com.example.fetchcodingexercise.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchcodingexercise.R
import com.example.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

@Composable
fun HeaderComponent(
    listId: Int,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.list_id_sticky_header, listId),
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )

            Icon(
                painter = if (isExpanded) painterResource(R.drawable.expand_less_icon) else painterResource(
                    R.drawable.expand_more_icon
                ),
                contentDescription = if (isExpanded) stringResource(R.string.expand_less_icon_content_description) else stringResource(
                    R.string.expand_more_icon_content_description
                )
            )
        }
    }
}

@Preview
@Composable
fun HeaderComponentPreview() {
    FetchCodingExerciseTheme {
        HeaderComponent(
            listId = 34,
            onClick = {},
            isExpanded = false
        )
    }
}