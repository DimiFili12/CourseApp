package com.example.core.data.datasource

import com.example.core.database.dao.CourseDao
import com.example.core.database.model.CourseEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CourseLocalDataSourceImpl @Inject constructor(
    private val courseDao: CourseDao,
    private val ioDispatcher: CoroutineDispatcher
) : CourseLocalDataSource {

    override fun getAllCourses(): Flow<List<CourseEntity>> = courseDao.getAllCourses()

    override fun getCourseById(id: Int): Flow<CourseEntity> = courseDao.getCourseById(id)

    override suspend fun updateProgress(id: Int, progress: Int) {
        withContext(ioDispatcher) {
            courseDao.updateProgress(id, progress)
        }
    }
}