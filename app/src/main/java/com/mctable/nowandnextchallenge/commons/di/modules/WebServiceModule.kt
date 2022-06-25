package com.mctable.nowandnextchallenge.commons.di.modules

import com.mctable.nowandnextchallenge.commons.constants.AppConstants
import com.mctable.nowandnextchallenge.dashboard.data.api.ChannelsWebService
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object WebServiceModule {

    @Provides
    fun getRetrofitInstance() = Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun getChannelsWebService(retrofit: Retrofit) = retrofit.create(ChannelsWebService::class.java)

    @Provides
    fun getChannelsRepository(service: ChannelsWebService) = ChannelsRepository(service)

}