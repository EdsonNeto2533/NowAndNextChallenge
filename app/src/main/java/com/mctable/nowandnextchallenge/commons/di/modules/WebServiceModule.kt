package com.mctable.nowandnextchallenge.commons.di.modules

import com.mctable.nowandnextchallenge.commons.constants.AppConstants
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

}