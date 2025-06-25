package com.example.core.domain.usecase

import com.example.core.domain.repository.CourseRepository
import javax.inject.Inject

class UpdateCourseProgressUseCase@Inject constructor(
    private val repository: CourseRepository
) {
    suspend operator fun invoke(courseId: Int, progress: Int) {
        repository.updateCourseProgress(courseId, progress)
    }
}