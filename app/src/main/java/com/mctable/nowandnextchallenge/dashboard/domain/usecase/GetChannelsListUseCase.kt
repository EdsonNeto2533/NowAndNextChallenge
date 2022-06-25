package com.mctable.nowandnextchallenge.dashboard.domain.usecase

import com.mctable.nowandnextchallenge.dashboard.data.mapper.GetChannelBaseModelMapper
import com.mctable.nowandnextchallenge.dashboard.data.response.ChannelsResponse
import com.mctable.nowandnextchallenge.dashboard.data.response.ProgramResponse
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelBaseModel
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelStructureModel
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import javax.inject.Inject

class GetChannelsListUseCase @Inject constructor(
    private val repository: ChannelsRepository
) {

    private val programList = mutableListOf<Pair<ProgramResponse, ProgramResponse>>()
    private val mapper = GetChannelBaseModelMapper()

    suspend fun getChannels(skip: String?): ChannelBaseModel? {
        val channelsList = repository.getChannelsList(skip)

        getPrograms(channelsList)

        return channelsList?.let {
            ChannelBaseModel(
                channelsList = mapper.transform(
                    ChannelStructureModel(
                        it.channelsList,
                        programList
                    )
                )
            )

        }
    }

    private suspend fun getPrograms(channelsList: ChannelsResponse?) {
        channelsList?.channelsList?.forEach { channel ->
            val programResponse = repository.getProgramDetails(channel.callLetter)

            programResponse?.let { program ->
                programList.add(Pair(program.programList[0], program.programList[1]))
            }

        }
    }
}