package com.mctable.nowandnextchallenge.dashboard.domain.sealedclass

import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelModel

sealed class ChannelsUIState {
    object Error : ChannelsUIState()

    class Success(val channelsList: List<ChannelModel>) : ChannelsUIState()
}
