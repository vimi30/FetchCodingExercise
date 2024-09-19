package com.example.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.fetchcodingexercise.screens.HomeScreen
import com.example.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme
import com.example.fetchcodingexercise.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchCodingExerciseTheme {
                HomeScreen(
                    homeViewModel.viewState,
                    homeViewModel::getAllItems,
                    homeViewModel.expandedStates,
                    homeViewModel::expandList
                )
            }
        }
    }
}
