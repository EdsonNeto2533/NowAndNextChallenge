package com.mctable.nowandnextchallenge.dashboard.data.mapper

import com.mctable.nowandnextchallenge.commons.utils.interfaces.IMapper
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelModel
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelStructureModel

class GetChannelBaseModelMapper : IMapper<ChannelStructureModel, List<ChannelModel>> {

    override fun transform(data: ChannelStructureModel): List<ChannelModel> {
        val channelList = mutableListOf<ChannelModel>()
        data.channelsList.forEachIndexed { index, channel ->
            channelList.add(
                ChannelModel(
                    title = channel.title,
                    callLetter = channel.callLetter,
                    nowPlaying = data.programList[index].first.title,
                    nextProgram = data.programList[index].second.title,
                    image = null
                )
            )
        }
        return channelList
    }

}