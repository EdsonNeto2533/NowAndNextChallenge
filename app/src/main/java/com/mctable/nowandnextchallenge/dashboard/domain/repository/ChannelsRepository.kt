package com.mctable.nowandnextchallenge.dashboard.domain.repository

import com.mctable.nowandnextchallenge.commons.constants.AppConstants
import com.mctable.nowandnextchallenge.commons.utils.baseClasses.BaseRepository
import com.mctable.nowandnextchallenge.commons.utils.generics.GenericFunctions
import com.mctable.nowandnextchallenge.dashboard.data.api.ChannelsWebService
import com.mctable.nowandnextchallenge.dashboard.data.response.ChannelsResponse
import com.mctable.nowandnextchallenge.dashboard.data.response.ProgramBaseResponse
import com.mctable.nowandnextchallenge.dashboard.data.response.ProgramResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChannelsRepository @Inject constructor(
    private val webService: ChannelsWebService
) : BaseRepository() {

    suspend fun getChannelsList(skip: String?): ChannelsResponse? {
        return withContext(Dispatchers.Default) {
            checkResponse(
                webService.getChannelsList(
                    skip = skip
                )
            )
        }
    }

    suspend fun getProgramDetails(callLetter: String): ProgramBaseResponse? {
        return withContext(Dispatchers.Default) {
            checkResponse(
                webService.getProgramsDetails(
                    url = GenericFunctions.getProgramEndpoint(callLetter)
                )
            )
        }
    }
}