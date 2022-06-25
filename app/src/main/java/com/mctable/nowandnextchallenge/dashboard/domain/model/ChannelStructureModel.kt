package com.mctable.nowandnextchallenge.dashboard.domain.model

import com.mctable.nowandnextchallenge.dashboard.data.response.Channel
import com.mctable.nowandnextchallenge.dashboard.data.response.ProgramResponse

data class ChannelStructureModel(
    val channelsList: List<Channel>,
    val programList: List<Pair<ProgramResponse, ProgramResponse>>
)
