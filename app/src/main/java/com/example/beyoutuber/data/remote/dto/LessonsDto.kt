package com.example.beyoutuber.data.remote.dto

import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.common.LessonNumber
import com.example.beyoutuber.domain.model.Lesson
import com.example.beyoutuber.domain.model.Lessons
import com.example.beyoutuber.domain.model.ShareInfo
import com.google.gson.annotations.SerializedName

data class LessonsDto(
    val banner_id: String,
    val banner_show: Boolean,
    @SerializedName("data")
    val LessonList: List<LessonDto>,
    val gecis_id: String,
    val kac_defada_gosterilsin: Int,
    val paylas_show: Boolean,
    val paylas_text: String
)

fun LessonsDto.toLessons():Lessons
{
    var num=0
    val tmpList:List<Lesson> = LessonList.map {
        it.toLesson(num++)
    }
    LessonNumber.lessonNumber = num
    return Lessons(
        LessonList=tmpList,
    )
}
fun LessonsDto.toShareInfo():ShareInfo
{
        return ShareInfo(
            kac_defada_gosterilsin = kac_defada_gosterilsin,
            paylas_text = paylas_text,
            paylas_show = paylas_show
        )
}