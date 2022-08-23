package com.example.beyoutuber.presentation.share.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.beyoutuber.presentation.share.ShareViewModel

@Composable
fun ShareScreen(
    viewModel: ShareViewModel= hiltViewModel()
)
{
    val state=viewModel.state.value

    Box(modifier = Modifier.fillMaxWidth())
    {
        if(state.isLoading)
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        else if(state.error.isNotBlank())
        {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = state.error
            )
        }
        else
        {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.primary
                    )
                    .border(width = 1.dp, color = Color.Black)
                    .padding(16.dp)
                )
            {
                if(state.shareInfo?.paylas_show == true)
                {
                    ShareText(
                        text = state.shareInfo.paylas_text,
                        displayNumber = state.shareInfo.kac_defada_gosterilsin
                    )
                }
            }

        }
    }

}

@Preview
@Composable
fun ShareScreenPreview()
{

}