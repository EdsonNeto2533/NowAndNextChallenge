package com.mctable.nowandnextchallenge.commons.di.modules

import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import com.mctable.nowandnextchallenge.dashboard.domain.usecase.GetChannelsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun getChannelsUseCase(repository: ChannelsRepository) = GetChannelsListUseCase(repository)
}