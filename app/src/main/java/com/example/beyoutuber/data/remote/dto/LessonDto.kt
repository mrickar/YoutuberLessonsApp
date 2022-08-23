package com.example.beyoutuber.data.remote.dto

import com.example.beyoutuber.common.LessonNumber
import com.example.beyoutuber.domain.model.Lesson
import java.util.*

data class LessonDto(
    val baslik: String,
    val icerik: String,
    val icon: String,
)

fun LessonDto.toLesson(uid:Int):Lesson
{
    return Lesson(
        baslik = baslik,
        icerik=icerik,
        icon = icon,
        uid = uid.toString()
    )
}