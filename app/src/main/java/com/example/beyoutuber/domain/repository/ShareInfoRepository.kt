package com.example.beyoutuber.domain.repository

import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.model.ShareInfo
import kotlinx.coroutines.flow.Flow

interface  ShareInfoRepository {
    suspend fun getShareInfo(): Flow<Resource<ShareInfo>>
}