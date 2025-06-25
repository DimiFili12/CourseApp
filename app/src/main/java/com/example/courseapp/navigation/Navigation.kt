package com.example.courseapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import com.example.feature.coursedetails.navigation.courseDetailsScreen
import com.example.feature.coursedetails.navigation.CourseDetails
import com.example.feature.courselist.navigation.CourseList
import com.example.feature.courselist.navigation.courseListScreen

@Composable
fun MainNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = CourseList.route
    ) {
        courseListScreen { courseId ->
            navController.navigate(CourseDetails.createRoute(courseId))
        }
        courseDetailsScreen( onBack = { navController.popBackStack() } )
    }
}