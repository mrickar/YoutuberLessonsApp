package com.example.beyoutuber.presentation.main_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.beyoutuber.R
import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.common.LessonNumber
import com.example.beyoutuber.common.LessonNumber.lessonNumber
import com.example.beyoutuber.presentation.Screen
import com.example.beyoutuber.presentation.lesson_list.LessonListViewModel
import com.example.beyoutuber.presentation.ui.theme.*
import kotlin.random.Random


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun MainScreen(
    navController: NavController?=null,
    lessonListViewModel: LessonListViewModel = hiltViewModel()
)
{
    val WhiteTransparent=Color(0x8CFFFFFF)
    val buttonRoutes:HashMap<String,String?> =hashMapOf(
        "Dersler" to Screen.LessonListScreen.route + "/${Constants.LIST_NOT_REVERSED}",
        "Son Dersler" to Screen.LessonListScreen.route + "/${Constants.LIST_REVERSED}",
        "Random" to null,
        "Paylaş" to Screen.ShareScreen.route,
        "Uygulama Hk" to Screen.AboutAppScreen.route,
        "Geliştirici" to Screen.DeveloperScreen.route
    )
    val buttonNames= listOf<String>(
        "Dersler" ,
        "Son Dersler",
        "Random" ,
        "Paylaş" ,
        "Uygulama Hk" ,
        "Geliştirici"
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
    )
    {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription =null,
            contentScale = ContentScale.FillBounds ,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Youtuber Olmak ve Para Kazanmak",
                style = MaterialTheme.typography.h6
            )
            Image(
                painter = painterResource(id = R.drawable.youtube_circle_icon),
                contentDescription = null,
                modifier = Modifier.height(160.dp)
            )
//            Spacer(modifier = Modifier.height(196.dp))
            Box(
                modifier= Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
                    .background(
                        color = WhiteTransparent
                    )
                    .weight(1f,false)
            )
            {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth(),
//                        .padding(vertical = 24.dp, horizontal = 16.dp),
                    cells = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(48.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp)
                )
                {
                    items(items = buttonNames) { buttonName->
                        navigationButton(
                            buttonName = buttonName,
                            onItemClick = {
                                if(buttonName=="Random")
                                {
                                    val randomLesson=(0..lessonNumber).random()
                                    navController!!.navigate(Screen.LessonDetailsScreen.route + "/${randomLesson}")
                                }
                                else navController!!.navigate(buttonRoutes[buttonName]!!)
                            }
                        )
                    }
                }
            }
        }
    }

}