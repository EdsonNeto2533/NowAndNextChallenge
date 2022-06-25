package com.mctable.nowandnextchallenge.commons.di.modules

import com.mctable.nowandnextchallenge.dashboard.data.api.ChannelsWebService
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun getChannelsRepository(service: ChannelsWebService) = ChannelsRepository(service)
}