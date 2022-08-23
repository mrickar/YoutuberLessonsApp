package com.example.beyoutuber.domain.use_case.get_lessons

import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.model.Lessons
import com.example.beyoutuber.domain.repository.LessonsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLessonsUseCase @Inject constructor(
    val repository: LessonsRepository,
) {
    suspend operator fun invoke(): Flow<Resource<Lessons>> {
        return repository.getLessons()
    }
}