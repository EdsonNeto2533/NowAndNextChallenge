package com.mctable.nowandnextchallenge.commons.utils.baseClasses

import retrofit2.Response

abstract class BaseRepository {

    fun <T> checkResponse(response: Response<T>): T? {
        return if (response.isSuccessful) {
            response.body()
        } else
            null
    }

}