package com.example.beyoutuber.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.presentation.about_app.AboutAppScreen
import com.example.beyoutuber.presentation.developer.DeveloperScreen
import com.example.beyoutuber.presentation.lesson_details.components.LessonDetailsScreen
import com.example.beyoutuber.presentation.lesson_list.components.LessonListScreen
import com.example.beyoutuber.presentation.main_screen.components.MainScreen
import com.example.beyoutuber.presentation.share.components.ShareScreen
import com.example.beyoutuber.presentation.splash_screen.SplashScreen



@Composable
fun makeNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route)
    {
        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(navController)
        }
        composable(
            route = Screen.LessonListScreen.route + "/{${Constants.IS_LIST_REVERSED}}"
        ) {
            LessonListScreen(navController)
        }
        composable(
            route = Screen.LessonDetailsScreen.route + "/{${Constants.PARAM_UID}}"
        ) {
            LessonDetailsScreen()
        }
        composable(
            route = Screen.ShareScreen.route
        ) {
            ShareScreen()
        }
        composable(
            route = Screen.AboutAppScreen.route
        ) {
            AboutAppScreen()
        }
        composable(
            route = Screen.DeveloperScreen.route
        ) {
            DeveloperScreen()
        }
        composable(
            route = Screen.SplashScreen.route
        )
        {
            SplashScreen(navController)
        }
    }
}
