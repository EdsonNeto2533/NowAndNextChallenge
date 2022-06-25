package com.mctable.nowandnextchallenge.dashboard.data.response

import com.google.gson.annotations.SerializedName

data class ProgramBaseResponse(
    @SerializedName("value")
    val programList: List<ProgramResponse>
)

data class ProgramResponse(
    @SerializedName("Title")
    val title: String,
    @SerializedName("CallLetter")
    val image: String
)
