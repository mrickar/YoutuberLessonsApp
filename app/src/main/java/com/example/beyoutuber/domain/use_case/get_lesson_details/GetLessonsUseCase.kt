package com.example.beyoutuber.domain.use_case.get_lesson_details

import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.model.Lesson
import com.example.beyoutuber.domain.repository.LessonsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLessonDetailsUseCase @Inject constructor(
    val repository: LessonsRepository,
) {
    suspend operator fun invoke(uid:String): Flow<Resource<Lesson>> {
        return repository.getLessonDetailsByUid(uid)
    }
}