package com.example.beyoutuber.presentation.lesson_details

import com.example.beyoutuber.domain.model.Lesson


data class LessonDetailsState(
    val lesson: Lesson?=null,
    val isLoading:Boolean=false,
    val error:String=""
    )