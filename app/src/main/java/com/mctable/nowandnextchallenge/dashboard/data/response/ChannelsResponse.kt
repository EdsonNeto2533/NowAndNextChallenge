package com.mctable.nowandnextchallenge.dashboard.data.response

import com.google.gson.annotations.SerializedName

data class ChannelsResponse(
    @SerializedName("value")
    val channelsList: List<Channel>,
    @SerializedName("data.nextLink")
    val nextPageLink: String
)

data class Channel(
    @SerializedName("Title")
    val title: String,
    @SerializedName("CallLetter")
    val callLetter: String
)
