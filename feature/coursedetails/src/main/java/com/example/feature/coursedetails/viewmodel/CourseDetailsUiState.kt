package com.example.feature.coursedetails.viewmodel

import com.example.core.model.Course

sealed interface CourseDetailsUiState {
    data object Loading : CourseDetailsUiState
    data class Success(
        val course: Course,
        val editedProgress: Int,
    ) : CourseDetailsUiState
    data class Error(val message: String) : CourseDetailsUiState
}