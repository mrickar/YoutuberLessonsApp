package com.example.beyoutuber.presentation

sealed class Screen(val route:String)
{
    object LessonListScreen:Screen("lesson_list_screen")
    object LessonDetailsScreen:Screen("lesson_details_screen")
    object MainScreen:Screen("main_screen")
    object ShareScreen:Screen("share_screen")
    object AboutAppScreen:Screen("about_app_screen")
    object DeveloperScreen:Screen("developer_screen")
    object SplashScreen:Screen("splash_screen")
}
