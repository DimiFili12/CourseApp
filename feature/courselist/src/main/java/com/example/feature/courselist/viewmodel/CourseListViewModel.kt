package com.example.feature.courselist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.asResult
import com.example.core.common.Result
import com.example.core.domain.repository.CourseRepository
import com.example.core.domain.usecase.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class CourseListViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    val uiState: StateFlow<CourseListUiState> = getCoursesUseCase()
        .asResult()
        .map { result ->
            when (result) {
                is Result.Loading -> CourseListUiState.Loading
                is Result.Error -> CourseListUiState.Error("Failed to load: ${result.exception.message ?: "Unknown error"}")
                is Result.Success -> if (result.data.isEmpty()) CourseListUiState.Empty else CourseListUiState.Success(result.data)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CourseListUiState.Loading
        )
}
