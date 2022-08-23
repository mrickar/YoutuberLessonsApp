package com.example.beyoutuber.presentation.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.beyoutuber.R
import com.example.beyoutuber.presentation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
)
{
    LaunchedEffect(key1 = true)
    {
        delay(2500)
        navController.navigate(Screen.MainScreen.route)
        {
           popUpTo(0)
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.youtube_circle_icon),
            contentDescription =null,
            modifier = Modifier.height(96.dp)
            )
    }
}

@Preview
@Composable
fun SplashScreenPreview()
{
    SplashScreen(navController = rememberNavController())
}