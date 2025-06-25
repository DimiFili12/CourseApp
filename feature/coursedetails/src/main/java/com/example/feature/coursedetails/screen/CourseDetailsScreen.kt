package com.example.feature.coursedetails.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.ui.components.CustomCenterAlignedTopAppBar
import com.example.core.ui.components.FullScreenLoading
import com.example.feature.coursedetails.viewmodel.CourseDetailsUiState
import com.example.feature.coursedetails.viewmodel.CourseDetailsViewModel
import com.example.core.ui.components.ErrorScreen
import com.example.feature.coursedetails.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    viewModel: CourseDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CourseDetailScreen(
        uiState = uiState,
        onBack = onBack,
        onProgressChange = viewModel::updateProgress,
        onProgressSave = viewModel::saveChanges,
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CourseDetailScreen(
    uiState: CourseDetailsUiState,
    onBack: () -> Unit,
    onProgressChange: (Int) -> Unit,
    onProgressSave: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomCenterAlignedTopAppBar(
                canNavigateBack = true,
                onBack = onBack,
                title = stringResource(R.string.course_details)
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        when (uiState) {
            is CourseDetailsUiState.Error -> ErrorScreen(message = uiState.message)
            CourseDetailsUiState.Loading -> FullScreenLoading()
            is CourseDetailsUiState.Success ->
                CourseDetailsContent(
                    course = uiState.course,
                    editedProgress = uiState.editedProgress,
                    onProgressChange = onProgressChange,
                    onProgressSave = onProgressSave,
                    onBack = onBack,
                    modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
