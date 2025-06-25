package com.example.core.data

import com.example.core.data.datasource.CourseLocalDataSource
import com.example.core.data.mapper.CourseMapper
import com.example.core.data.repository.CourseRepositoryImpl
import com.example.core.domain.repository.CourseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCourseMapper(): CourseMapper = CourseMapper()

    @Provides
    fun provideCourseRepository(
        dataSource: CourseLocalDataSource,
        mapper: CourseMapper
    ): CourseRepository = CourseRepositoryImpl(dataSource, mapper)
}