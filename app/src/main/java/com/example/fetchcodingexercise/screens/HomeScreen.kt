package com.example.fetchcodingexercise.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fetchcodingexercise.R
import com.example.fetchcodingexercise.components.ErrorComponent
import com.example.fetchcodingexercise.components.HeaderComponent
import com.example.fetchcodingexercise.components.ListItemComponent
import com.example.fetchcodingexercise.components.LoadingStateComponent
import com.example.fetchcodingexercise.components.SimpleTopBar
import com.example.fetchcodingexercise.model.domain.ListItem
import com.example.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme
import com.example.fetchcodingexercise.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewState: StateFlow<UiState<List<ListItem>>>,
    fetchAllItems: () -> Unit,
    expandedStates: Map<Int, Boolean>,
    expandList: (Int) -> Unit
) {

    val uiState by viewState.collectAsState()

    LaunchedEffect(Unit) {
        fetchAllItems()
    }

    Scaffold(
        topBar = {
            SimpleTopBar(title = stringResource(R.string.home_screen_header))
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            when (val state = uiState) {
                is UiState.Error -> {

                    item {
                        ErrorComponent(
                            state.errorMessage
                        )
                    }

                }

                is UiState.Success -> {
                    val groupedItems = state.data.groupBy { it.listId }.toSortedMap()

                    groupedItems.forEach { (listId, list) ->
                        val isExpanded = expandedStates[listId] ?: false
                        stickyHeader {
                            HeaderComponent(
                                listId = listId,
                                isExpanded = isExpanded,
                                onClick = {
                                    expandList(listId)
                                }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                        if (isExpanded) {
                            items(list.sortedBy { it.name }, key = { it.id }) { listItem ->
                                ListItemComponent(listItem)
                            }
                        }
                    }
                }

                UiState.Loading -> {
                    item {
                        LoadingStateComponent(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(124.dp)
                        )
                    }

                }

            }

        }

    }
}

@Preview
@Composable
fun HomeScreenLoadingPreview() {
    FetchCodingExerciseTheme {
        HomeScreen(
            viewState = MutableStateFlow(UiState.Loading),
            fetchAllItems = {},
            expandedStates = emptyMap(),
            expandList = {}

        )
    }
}

@Preview
@Composable
fun HomeScreenErrorPreview() {
    FetchCodingExerciseTheme {
        HomeScreen(
            viewState = MutableStateFlow(UiState.Error("Something went wrong")),
            fetchAllItems = {},
            expandedStates = emptyMap(),
            expandList = {}

        )
    }
}

@Preview
@Composable
fun HomeScreenSuccessPreview() {
    FetchCodingExerciseTheme {
        HomeScreen(
            viewState = MutableStateFlow(
                UiState.Success(
                    data = listOf(
                        ListItem(
                            id = 1,
                            name = "item 1",
                            listId = 1
                        ),
                        ListItem(
                            id = 2,
                            name = "item 2",
                            listId = 2
                        ),
                        ListItem(
                            id = 3,
                            name = "item 3",
                            listId = 3
                        ),
                        ListItem(
                            id = 4,
                            name = "item 4",
                            listId = 4
                        )
                    )
                )
            ),
            fetchAllItems = {},
            expandedStates = emptyMap(),
            expandList = {}
        )

    }
}