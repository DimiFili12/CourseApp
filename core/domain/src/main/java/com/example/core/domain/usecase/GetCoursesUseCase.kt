package com.example.core.domain.usecase

import com.example.core.domain.repository.CourseRepository
import com.example.core.model.Course
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoursesUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(): Flow<List<Course>> = repository.getCoursesFlow()
}