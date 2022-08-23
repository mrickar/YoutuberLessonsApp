package com.example.beyoutuber.presentation.lesson_details.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.beyoutuber.presentation.lesson_details.LessonDetailsViewModel
import com.example.beyoutuber.presentation.lesson_list.components.LessonListItem

//@Preview(showBackground = true)
@Composable
fun LessonDetailsScreen(
    viewModel: LessonDetailsViewModel = hiltViewModel()
)
{
    val state=viewModel.state.value
    val lesson=state.lesson
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp))
    {

        lesson?.let {
            LazyColumn(modifier = Modifier.fillMaxWidth(),contentPadding = PaddingValues(20.dp)) {
                item {
                    LessonListItem(lesson = lesson, onItemClick = null)
                    AndroidView(factory = {
                        WebView(it).apply {
                            webViewClient = WebViewClient()
                            loadDataWithBaseURL(null, lesson.icerik, "text/HTML", "UTF-8", null)
                        }
                    },
                    modifier = Modifier.align(Alignment.Center))
                }
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