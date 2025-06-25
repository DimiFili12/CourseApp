package com.example.feature.courselist.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.ui.components.ErrorScreen
import com.example.core.ui.components.FullScreenLoading
import com.example.feature.courselist.viewmodel.CourseListUiState
import com.example.feature.courselist.viewmodel.CourseListViewModel


@Composable
internal fun CourseListScreen(
    modifier: Modifier = Modifier,
    viewModel: CourseListViewModel = hiltViewModel(),
    onCourseClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CourseListScreen(
        uiState = uiState,
        onCourseClick = onCourseClick,
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CourseListScreen(
    uiState: CourseListUiState,
    onCourseClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Courses") }) },
        modifier = modifier.fillMaxSize()
    ) { padding ->
        when (uiState) {
            CourseListUiState.Loading -> FullScreenLoading()
            CourseListUiState.Empty -> EmptyScreen()
            is CourseListUiState.Error -> ErrorScreen(message = uiState.message)
            is CourseListUiState.Success -> CourseListContent(
                courses = uiState.courses,
                onCourseClick = onCourseClick,
                modifier = Modifier.padding(padding)
            )
        }
    }
}