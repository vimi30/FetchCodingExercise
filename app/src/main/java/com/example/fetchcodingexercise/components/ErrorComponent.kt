package com.example.fetchcodingexercise.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fetchcodingexercise.R
import com.example.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

@Composable
fun ErrorComponent(errorMessage: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(color = Color.White, shape = RoundedCornerShape(12.dp)),

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.error_icon),
                contentDescription = stringResource(R.string.error_icon_content_description),
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = errorMessage,
                textAlign = TextAlign.Center,
                color = Color.Red,
                modifier = Modifier
                    .padding(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun ErrorComponentPreview(){
    FetchCodingExerciseTheme {
        ErrorComponent(
            errorMessage = "Something went wrong"
        )
    }
}