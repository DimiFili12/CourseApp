package com.example.feature.coursedetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.coursedetails.navigation.CourseDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.core.common.asResult
import com.example.core.common.Result
import com.example.core.domain.usecase.GetCourseByIdUseCase
import com.example.core.domain.usecase.UpdateCourseProgressUseCase


@HiltViewModel
class CourseDetailsViewModel @Inject constructor(
    private val getCourseByIdUseCase: GetCourseByIdUseCase,
    private val updateCourseProgressUseCase: UpdateCourseProgressUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val courseIdState = savedStateHandle.getStateFlow<Int?>(CourseDetails.courseIdArg, null)

    private val _editedProgress = MutableStateFlow<EditState>(EditState.NotEdited)

    val uiState: StateFlow<CourseDetailsUiState> = courseIdState
        .filterNotNull()
        .flatMapLatest { id ->
            getCourseByIdUseCase(id)
                .asResult() // Wraps flow emissions as Loading/Success/Error
                .combine(_editedProgress) { result, editedProgress ->
                    when (result) {
                        is Result.Loading -> CourseDetailsUiState.Loading
                        is Result.Error -> CourseDetailsUiState.Error(result.exception.message ?: "Failed to load course details")
                        is Result.Success -> {
                            val progress = when (editedProgress) {
                                EditState.NotEdited -> result.data.progress
                                is EditState.Edited -> editedProgress.progress
                            }
                            CourseDetailsUiState.Success(result.data, progress)
                        }
                    }
                }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CourseDetailsUiState.Loading
        )

    fun updateProgress(newProgress: Int) {
        _editedProgress.value = EditState.Edited(newProgress)
    }

    fun saveChanges(courseId: Int, newProgress: Int) {
        viewModelScope.launch {
            updateCourseProgressUseCase(courseId, newProgress)
            _editedProgress.value = EditState.NotEdited
        }
    }
}