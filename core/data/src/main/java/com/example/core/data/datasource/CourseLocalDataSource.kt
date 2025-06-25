package com.example.core.data.datasource

import com.example.core.database.model.CourseEntity
import kotlinx.coroutines.flow.Flow

interface CourseLocalDataSource {
    fun getAllCourses(): Flow<List<CourseEntity>>
    fun getCourseById(id: Int): Flow<CourseEntity>
    suspend fun updateProgress(id: Int, progress: Int)
}

