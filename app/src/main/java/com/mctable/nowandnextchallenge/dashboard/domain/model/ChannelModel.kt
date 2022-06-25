package com.mctable.nowandnextchallenge.dashboard.domain.model

data class ChannelBaseModel(
    val channelsList: List<ChannelModel>,
)

data class ChannelModel(
    val title: String,
    val callLetter: String,
    val nowPlaying: String,
    val nextProgram: String,
    val image: String?
)
