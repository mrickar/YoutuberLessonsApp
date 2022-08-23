package com.example.beyoutuber.presentation.developer

import HyperlinkText
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun DeveloperScreen()
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

    ) {
        Text(text = "Merhaba ben Meriç KARADAYI. ODTU Bilgisayar Mühendisliği 2.sınıf öğrencisiyim.")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "İletişim", textDecoration = TextDecoration.Underline)
        Spacer(modifier = Modifier.height(16.dp))
        HyperlinkText(fullText = "LinkedIn: https://www.linkedin.com/in/meric-karadayi/", linkText = listOf("https://www.linkedin.com/in/meric-karadayi/"), hyperlinks = listOf("https://www.linkedin.com/in/meric-karadayi/"), linkTextColor = MaterialTheme.colors.onPrimary)
        HyperlinkText(fullText = "GitHub: https://github.com/mrickar", linkText = listOf("https://github.com/mrickar"), hyperlinks = listOf("https://github.com/mrickar"),linkTextColor = MaterialTheme.colors.onPrimary)
    }
}