package com.example.beyoutuber.presentation.share

import com.example.beyoutuber.domain.model.ShareInfo

data class ShareState (
    val shareInfo:ShareInfo?=null,
    val error:String="",
    var isLoading:Boolean=false
        )