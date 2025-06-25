package com.example.feature.courselist.viewmodel

import com.example.core.model.Course


sealed interface CourseListUiState {
    data object Loading : CourseListUiState
    data object Empty : CourseListUiState
    data class Success(val courses: List<Course>) : CourseListUiState
    data class Error(val message: String) : CourseListUiState
}