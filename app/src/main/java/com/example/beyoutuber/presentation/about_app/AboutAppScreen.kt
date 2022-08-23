package com.example.beyoutuber.presentation.about_app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beyoutuber.presentation.Screen

@Preview(showBackground = true)
@Composable
fun AboutAppScreen(
)
{
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.primary
            )
            .border(width = 1.dp, color = Color.Black)
            .padding(16.dp)


    ){
        Text(text = "Bu uygulama Youtuber olmak ve Para kazanmak isteyenler için:")
        Text(text = "https://apps.furkansandal.com/youtuber_app_v2/show_json", fontStyle = FontStyle.Italic)
        Text(text = "Servisine göre Meriç Karadayı tarafından geliştirilmiştir")
    }
}