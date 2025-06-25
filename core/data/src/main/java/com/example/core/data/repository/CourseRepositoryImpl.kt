package com.example.core.data.repository

import com.example.core.data.datasource.CourseLocalDataSource
import com.example.core.data.mapper.CourseMapper
import com.example.core.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.example.core.model.Course

class CourseRepositoryImpl @Inject constructor(
    private val dataSource: CourseLocalDataSource,
    private val mapper: CourseMapper
) : CourseRepository {

    override fun getCoursesFlow(): Flow<List<Course>> {
        return dataSource.getAllCourses().map { entities ->
            entities.map { mapper.toDomain(it) }
        }
    }

    override fun getCourseById(id: Int): Flow<Course> {
        return dataSource.getCourseById(id)
            .map { mapper.toDomain(it) }
    }

    override suspend fun updateCourseProgress(id: Int, progress: Int) {
        dataSource.updateProgress(id, progress)
    }
}