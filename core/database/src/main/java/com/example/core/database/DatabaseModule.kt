package com.example.core.database

import android.content.Context
import com.example.core.database.dao.CourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCourseDatabase(@ApplicationContext context: Context): CourseDatabase {
        return CourseDatabase.create(context)
    }

    @Provides
    fun provideCourseDao(database: CourseDatabase): CourseDao = database.courseDao()
}