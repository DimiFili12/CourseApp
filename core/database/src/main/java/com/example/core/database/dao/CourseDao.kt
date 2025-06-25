package com.example.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.core.database.model.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAllCourses(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM courses WHERE id = :id")
    fun getCourseById(id: Int): Flow<CourseEntity>

    @Query("UPDATE courses SET progress = :progress WHERE id = :id")
    suspend fun updateProgress(id: Int, progress: Int)
}