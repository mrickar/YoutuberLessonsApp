package com.example.beyoutuber.presentation.lesson_details


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.use_case.get_lesson_details.GetLessonDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonDetailsViewModel @Inject constructor(
    val getLessonDetailsUseCase: GetLessonDetailsUseCase,
    savedStateHandle: SavedStateHandle,
):ViewModel() {

    private val _state= mutableStateOf<LessonDetailsState>(LessonDetailsState())
    val state:State<LessonDetailsState> = _state

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(Constants.PARAM_UID)?.let { uid->
                getLessonDetails(uid)
            }
        }
    }
    private suspend fun getLessonDetails(uid:String)
    {
        getLessonDetailsUseCase(uid).onEach {
            when(it)
            {
                is Resource.Success ->
                {
                    _state.value= LessonDetailsState(lesson = it.data)
                }
                is Resource.Error->
                {
                    _state.value= LessonDetailsState(error = "ERROR")
                }
                is Resource.Loading->
                {
                    _state.value= LessonDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}