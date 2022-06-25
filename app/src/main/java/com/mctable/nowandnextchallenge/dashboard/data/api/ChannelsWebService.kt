package com.mctable.nowandnextchallenge.dashboard.data.api

import com.mctable.nowandnextchallenge.commons.constants.AppConstants
import com.mctable.nowandnextchallenge.dashboard.data.response.ChannelsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChannelsWebService {

    @GET("catalog/v9/Channels")
    suspend fun getChannelsList(
        @Query("UserAgent") userAgent: String = AppConstants.DEFAULT_USER_AGENT,
        @Query("filter") filter: String = AppConstants.DEFAULT_FILTER,
        @Query("orderby") orderBy: String = AppConstants.DEFAULT_ORDINATION,
        @Query("inlinecount") inlineCount: String = AppConstants.DEFAULT_INLINE_COUNT,
        @Query("skip") skip: String?
    ): Response<ChannelsResponse>
}