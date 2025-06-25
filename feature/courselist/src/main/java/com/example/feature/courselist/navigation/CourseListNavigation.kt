package com.example.feature.courselist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature.courselist.screen.CourseListScreen

fun NavGraphBuilder.courseListScreen(
    onCourseClick: (Int) -> Unit
) {
    composable(CourseList.route) {
        CourseListScreen(onCourseClick = onCourseClick)
    }
}