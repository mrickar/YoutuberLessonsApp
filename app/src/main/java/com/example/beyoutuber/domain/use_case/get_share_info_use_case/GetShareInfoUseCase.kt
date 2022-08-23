package com.example.beyoutuber.domain.use_case.get_share_info_use_case

import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.model.ShareInfo
import com.example.beyoutuber.domain.repository.ShareInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetShareInfoUseCase @Inject constructor(
    val repository: ShareInfoRepository
) {
    suspend operator fun invoke(): Flow<Resource<ShareInfo>> {
        return repository.getShareInfo()
    }
}