package com.mctable.nowandnextchallenge.dashboard.domain.usecase

import com.mctable.nowandnextchallenge.dashboard.data.mapper.GetChannelBaseModelMapper
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
    private var aux: ChannelBaseModel? = null

    suspend fun getChannels(skip: String?): ChannelBaseModel? {
        val channelsList = repository.getChannelsList(skip)

        channelsList?.channelsList?.forEach {
            val response = repository.getProgramDetails(it.callLetter)
            response?.let { program ->
                programList.add(Pair(program.programList[0], program.programList[1]))
            }

        }
        channelsList?.let {
            aux = ChannelBaseModel(
                channelsList = mapper.transform(
                    ChannelStructureModel(
                        it.channelsList,
                        programList
                    )
                ), nextPage = it.nextPageLink
            )

        }

        return aux
    }
}