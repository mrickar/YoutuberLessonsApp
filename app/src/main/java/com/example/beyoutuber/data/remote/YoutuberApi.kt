package com.example.beyoutuber.data.remote


import com.example.beyoutuber.data.remote.dto.LessonsDto
import retrofit2.http.GET


interface YoutuberApi {

    @GET("/youtuber_app_v2/show_json")
    suspend fun getLessons(): LessonsDto

}


