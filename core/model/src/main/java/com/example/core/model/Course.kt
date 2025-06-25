package com.example.core.model

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val image: String?,
    val progress: Int
)