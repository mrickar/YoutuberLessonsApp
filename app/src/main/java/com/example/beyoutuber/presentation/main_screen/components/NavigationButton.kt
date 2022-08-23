package com.example.beyoutuber.presentation.main_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.beyoutuber.domain.model.Lesson
import com.example.beyoutuber.presentation.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun navigationButton(
    @PreviewParameter(NameProvider::class) buttonName:String,
    onItemClick: ((String) -> Unit)?=null
)
{
    Box(
        modifier = Modifier
            .clickable {
                if (onItemClick != null) {
                    onItemClick(buttonName)
                }
            }
            .border(
                shape = RoundedCornerShape(5.dp),
                color = Color.Red,
                width = 1.dp
            )
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = buttonName,
            color = Color.Red,
            overflow = TextOverflow.Visible,
        )

    }
}

class NameProvider:PreviewParameterProvider<String>{
    override val values: Sequence<String>
        get() = listOf<String>(
            "Dersler" ,
            "Son Dersler",
            "Random" ,
            "Paylaş" ,
            "Uygulama Hk" ,
            "Geliştirici"
        ).asSequence()
}

