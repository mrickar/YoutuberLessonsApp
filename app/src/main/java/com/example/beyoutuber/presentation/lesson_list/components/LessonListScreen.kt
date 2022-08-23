package com.example.beyoutuber.presentation.lesson_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.beyoutuber.presentation.Screen
import com.example.beyoutuber.presentation.lesson_list.LessonListViewModel


@Composable
fun LessonListScreen(
    navController: NavController,
    viewModel: LessonListViewModel= hiltViewModel()
)
{
    val state=viewModel.state.value
    Box(modifier = Modifier.fillMaxSize())
    {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.lessons?.LessonList ?: emptyList())
            { lesson ->
               LessonListItem(
                   lesson = lesson,
                   onItemClick = {
                       navController.navigate(Screen.LessonDetailsScreen.route + "/${lesson.uid}")
                   }
               )
                Divider()
            }
        }
        if (state.isLoading)
        {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        else if(state.error.isNotBlank())
        {
            Text(text = state.error,
                color= MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
    }

}