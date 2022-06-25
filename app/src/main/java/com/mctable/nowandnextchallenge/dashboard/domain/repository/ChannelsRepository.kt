package com.mctable.nowandnextchallenge.dashboard.domain.repository

import com.mctable.nowandnextchallenge.commons.utils.baseClasses.BaseRepository
import com.mctable.nowandnextchallenge.dashboard.data.api.ChannelsWebService
import com.mctable.nowandnextchallenge.dashboard.data.response.ChannelsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChannelsRepository @Inject constructor(
    private val webService: ChannelsWebService
) : BaseRepository() {

    suspend fun getChannelsList(skip: String?): ChannelsResponse? {
        return try {
            withContext(Dispatchers.Default) {
                checkResponse(
                    webService.getChannelsList(
                        skip = skip
                    )
                )
            }
        } catch (e: Exception) {
            println(e)
            null
        }
    }
}