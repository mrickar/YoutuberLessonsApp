package com.example.beyoutuber.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.presentation.about_app.AboutAppScreen
import com.example.beyoutuber.presentation.developer.DeveloperScreen
import com.example.beyoutuber.presentation.lesson_details.components.LessonDetailsScreen
import com.example.beyoutuber.presentation.lesson_list.components.LessonListScreen
import com.example.beyoutuber.presentation.main_screen.components.MainScreen
import com.example.beyoutuber.presentation.share.components.ShareScreen
import com.example.beyoutuber.presentation.splash_screen.SplashScreen
import com.example.beyoutuber.presentation.ui.theme.BeYoutuberTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeYoutuberTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController= rememberNavController()
                    makeNavigation(navController = navController)
                }
            }
        }
    }
}