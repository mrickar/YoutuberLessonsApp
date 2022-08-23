package com.example.beyoutuber.presentation.lesson_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.beyoutuber.domain.use_case.get_lessons.GetLessonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.beyoutuber.common.Constants
import com.example.beyoutuber.common.Resource
import com.example.beyoutuber.domain.model.Lessons
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class LessonListViewModel @Inject constructor(
    val getLessonsUseCase: GetLessonsUseCase,
    private val savedStateHandle: SavedStateHandle,
):ViewModel() {

    private val _state = mutableStateOf<LessonListState>(LessonListState())
    val state : State<LessonListState> = _state

    init {
        viewModelScope.launch {
            getLessons()
        }
    }
    private suspend fun getLessons()
    {
        getLessonsUseCase().onEach {
            when(it)
            {
                is Resource.Success ->
                {
                    if(savedStateHandle.get<String>(Constants.IS_LIST_REVERSED)==Constants.LIST_REVERSED) _state.value=LessonListState(lessons = Lessons(it.data!!.LessonList.reversed()))
                    else _state.value=LessonListState(lessons = it.data)

                }
                is Resource.Error->
                {
                    _state.value=LessonListState(error = it.message!!)
                }
                is Resource.Loading->
                {
                    _state.value=LessonListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}