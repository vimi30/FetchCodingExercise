package com.example.fetchcodingexercise.viewmodel

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchcodingexercise.model.domain.ListItem
import com.example.fetchcodingexercise.repository.Repository
import com.example.fetchcodingexercise.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _viewSate = MutableStateFlow<UiState<List<ListItem>>>(UiState.Loading)
    val viewState = _viewSate.asStateFlow()

    private val _expandedStates = mutableStateMapOf<Int, Boolean>()
    val  expandedStates: Map<Int, Boolean> get()   = _expandedStates

    fun getAllItems() = viewModelScope.launch {
//        _viewSate.update { UiState.Loading }
        repository.fetchAllItems()
            .onSuccess { items ->
                _viewSate.update {
                    UiState.Success(
                        data = items
                    )
                }
            }
            .onFailure { exception ->
                _viewSate.update {
                    UiState.Error(errorMessage = exception.message ?: "Unknown Error")
                }
            }
    }

    fun expandList( groupId: Int) {
        val isExpanded  = _expandedStates[groupId] ?: false
        _expandedStates[groupId] = !isExpanded
    }

}