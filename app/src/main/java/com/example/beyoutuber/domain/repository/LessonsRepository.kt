package com.example.beyoutuber.domain.repository

import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.model.Lesson
import com.example.beyoutuber.domain.model.Lessons
import kotlinx.coroutines.flow.Flow

interface LessonsRepository {
    suspend fun getLessons():Flow<Resource<Lessons>>

    suspend fun getLessonDetailsByUid(uid:String):Flow<Resource<Lesson>>
}