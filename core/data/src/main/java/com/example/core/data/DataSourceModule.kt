package com.example.core.data

import com.example.core.common.Dispatcher
import com.example.core.common.DispatcherType
import com.example.core.data.datasource.CourseLocalDataSource
import com.example.core.data.datasource.CourseLocalDataSourceImpl
import com.example.core.database.dao.CourseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Dispatcher(DispatcherType.IO)
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideCourseDataSource(
        dao: CourseDao,
        @Dispatcher(DispatcherType.IO) ioDispatcher: CoroutineDispatcher
    ): CourseLocalDataSource = CourseLocalDataSourceImpl(dao, ioDispatcher)
}