package com.example.beyoutuber.presentation.lesson_list

import com.example.beyoutuber.domain.model.Lessons

data class LessonListState (
    val error: String ="",
    val isLoading:Boolean=false,
    val lessons:Lessons?=null,
    )