package com.mctable.nowandnextchallenge.dashboard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelModel
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import com.mctable.nowandnextchallenge.dashboard.domain.usecase.GetChannelsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getChannelsListUseCase: GetChannelsListUseCase
) : ViewModel() {

    private val skip = 10

    private val _channelList = MutableLiveData<List<ChannelModel>>()
    val channelList: LiveData<List<ChannelModel>> = _channelList

    init {
        getChannels()
    }

    private fun getChannels() {
        try {
            viewModelScope.launch {
                _channelList.value = getChannelsListUseCase.getChannels(null)?.channelsList
            }
        } catch (e: Exception) {
            println(e)
        }
    }

    fun loadMore() {
        viewModelScope.launch {
            getChannelsListUseCase.getChannels(skip.toString())
        }
    }
}