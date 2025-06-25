package com.example.feature.coursedetails.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.feature.coursedetails.screen.CourseDetailScreen

fun NavGraphBuilder.courseDetailsScreen(onBack: () -> Unit) {
    composable(
        route = CourseDetails.routeWithArgs,
        arguments = CourseDetails.arguments
    ) { backStackEntry ->
        CourseDetailScreen( onBack = onBack )
    }
}