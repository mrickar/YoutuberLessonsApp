package com.example.beyoutuber.di

import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.data.mocking.IsMock
import com.example.beyoutuber.data.mocking.MockInterceptor
import com.example.beyoutuber.data.remote.YoutuberApi
import com.example.beyoutuber.data.repository.LessonsRepositoryImpl
import com.example.beyoutuber.data.repository.ShareInfoRepositoryImpl
import com.example.beyoutuber.domain.repository.LessonsRepository
import com.example.beyoutuber.domain.repository.ShareInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideYoutuberApi():YoutuberApi
    {
        val client=OkHttpClient.Builder()
        if(IsMock.IS_MOCK)
        {
            val mockInterceptor=MockInterceptor()
            mockInterceptor.addMockInterceptorToBuilder(client)
        }
        return Retrofit.Builder()
            .client(client.build())
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YoutuberApi::class.java)
    }



    @Singleton
    @Provides
    fun provideLessonsRepository(api:YoutuberApi):LessonsRepository
    {
        return LessonsRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideShareInfoRepository(api:YoutuberApi):ShareInfoRepository
    {
        return ShareInfoRepositoryImpl(api)
    }

}