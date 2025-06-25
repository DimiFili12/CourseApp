package com.example.core.domain.repository

import com.example.core.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getCoursesFlow(): Flow<List<Course>>
    fun getCourseById(id: Int): Flow<Course>
    suspend fun updateCourseProgress(id: Int, progress: Int)
}