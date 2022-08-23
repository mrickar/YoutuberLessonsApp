package com.example.beyoutuber.presentation.share.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShareText(
    text:String,
    displayNumber: Int
)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for(i in 1..displayNumber)
        {
            Text(
                text = text
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}
@Preview(showBackground = true)
@Composable
fun ShareTextPreview()
{
    ShareText(text = "Hemen sende Youtube'tan para kazanmaya başla! https://apps.furkansandal.com/",5)
}