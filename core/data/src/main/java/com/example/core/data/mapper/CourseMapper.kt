package com.example.core.data.mapper

import com.example.core.database.model.CourseEntity
import com.example.core.model.Course

class CourseMapper {
    fun toDomain(entity: CourseEntity): Course = Course(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        image = entity.image,
        progress = entity.progress
    )
}