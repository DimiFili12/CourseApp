package com.example.feature.coursedetails.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core.ui.navigation.Destinations

object CourseDetails : Destinations {
    override val route = "course_details"
    const val courseIdArg = "course_id"

    val routeWithArgs = "$route/{$courseIdArg}"

    val arguments = listOf(
        navArgument(courseIdArg) { type = NavType.IntType }
    )

    fun createRoute(courseIdArg: Int) = "$route/$courseIdArg"
}