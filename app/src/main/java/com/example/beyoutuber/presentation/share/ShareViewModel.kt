package com.example.beyoutuber.presentation.share

import android.graphics.SweepGradient
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.use_case.get_share_info_use_case.GetShareInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShareViewModel @Inject constructor(
    val getShareInfoUseCase: GetShareInfoUseCase
):ViewModel() {

    private val _state= mutableStateOf<ShareState>(ShareState())
    val state:State<ShareState> = _state

    init {
        viewModelScope.launch {
            getShareInfo()
        }
    }
    private suspend fun getShareInfo()
    {
        getShareInfoUseCase().onEach { resource->
            when(resource)
            {
                is Resource.Success->
                {
                    _state.value=ShareState(shareInfo = resource.data)
                }
                is Resource.Error->
                {
                    _state.value= ShareState(error=resource.message!!)
                }
                is Resource.Loading->
                {
                    _state.value=ShareState(isLoading= true)
                }
            }
        }.launchIn(viewModelScope)
    }
}