package com.example.beyoutuber.data.repository

import android.util.Log
import com.example.beyoutuber.BuildConfig
import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.data.remote.YoutuberApi
import com.example.beyoutuber.data.remote.dto.LessonsDto
import com.example.beyoutuber.data.remote.dto.toLessons

import com.example.beyoutuber.domain.model.Lesson
import com.example.beyoutuber.domain.model.Lessons
import com.example.beyoutuber.domain.repository.LessonsRepository
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.nio.channels.FileChannel.open
import java.nio.channels.SocketChannel.open
import javax.inject.Inject


class LessonsRepositoryImpl @Inject constructor(
    private val api: YoutuberApi
):LessonsRepository {

    var lessonsFlow:Flow<Resource<Lessons>> = flow {
        try {
            emit(Resource.Loading<Lessons>())
            val lessons=api.getLessons().toLessons()
            emit(Resource.Success<Lessons>(lessons))
        }catch (e: HttpException) {
            emit(Resource.Error<Lessons>("An unexpected error has occured."))

        }catch (e:IOException){
            emit(Resource.Error<Lessons>("Couldn't reach the server."))
        }
    }

    override suspend fun getLessons(): Flow<Resource<Lessons>> {
        return this.lessonsFlow
    }

    override suspend fun getLessonDetailsByUid(uid:String): Flow<Resource<Lesson>> {
        return flow {
            try {
                emit(Resource.Loading<Lesson>())
                val lessons=api.getLessons().toLessons()
                for (lesson in lessons.LessonList)
                {
                    if(lesson.uid==uid)
                    {
                        emit(Resource.Success<Lesson>(lesson))
                        break
                    }
                }
            }catch (e: HttpException) {
                emit(Resource.Error<Lesson>("An unexpected error has occured."))

            }catch (e:IOException){
                emit(Resource.Error<Lesson>("Couldn't reach the server."))
            }
        }
    }

}