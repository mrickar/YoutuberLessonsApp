package com.example.beyoutuber.data.repository

import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.data.remote.YoutuberApi
import com.example.beyoutuber.data.remote.dto.toShareInfo
import com.example.beyoutuber.domain.model.Lessons
import com.example.beyoutuber.domain.model.ShareInfo
import com.example.beyoutuber.domain.repository.ShareInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ShareInfoRepositoryImpl @Inject constructor(
    val api: YoutuberApi
):ShareInfoRepository {
    override suspend fun getShareInfo(): Flow<Resource<ShareInfo>> {
        return flow {
            try {
                emit(Resource.Loading<ShareInfo>())
                val shareInfo=api.getLessons().toShareInfo()
                emit(Resource.Success<ShareInfo>(shareInfo))
            }
            catch (e:HttpException){
                emit(Resource.Error<ShareInfo>("An unexpected error has occured."))
            }
            catch (e:IOException)
            {
                emit(Resource.Error<ShareInfo>("Couldn't reach the server."))
            }
        }
    }
}