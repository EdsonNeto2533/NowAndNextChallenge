package com.mctable.nowandnextchallenge.dashboard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelModel
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import com.mctable.nowandnextchallenge.dashboard.domain.sealedclass.ChannelsUIState
import com.mctable.nowandnextchallenge.dashboard.domain.usecase.GetChannelsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getChannelsListUseCase: GetChannelsListUseCase
) : ViewModel() {

    private var skip = 10
    private var isFirstTime = true

    private val _setupRecyclerViewScrollListener = MutableLiveData<Unit>()
    val setupRecyclerViewScrollListener: LiveData<Unit> = _setupRecyclerViewScrollListener

    private val _channelListUIState = MutableLiveData<ChannelsUIState>()
    val channelListState: LiveData<ChannelsUIState> = _channelListUIState

    init {
        getChannels()
    }

    fun getChannels() {
        try {
            viewModelScope.launch {
                val response = getChannelsListUseCase.getChannels(null)?.channelsList
                response?.let {
                    _channelListUIState.value = ChannelsUIState.Success(it)
                    setupRecyclerScrollListener()
                } ?: run {
                    _channelListUIState.value = ChannelsUIState.Error
                }
            }
        } catch (e: Exception) {
            _channelListUIState.value = ChannelsUIState.Error
        }
    }

    private fun setupRecyclerScrollListener() {
        if (isFirstTime) {
            _setupRecyclerViewScrollListener.value = Unit
            isFirstTime = false
        }
    }

    fun loadMore() {
        try {
            viewModelScope.launch {
                val response = getChannelsListUseCase.getChannels(skip.toString())?.channelsList
                response?.let {
                    _channelListUIState.value = ChannelsUIState.Success(it)
                    skip += 10
                } ?: run {
                    _channelListUIState.value = ChannelsUIState.Error
                }
            }
        } catch (e: Exception) {
            _channelListUIState.value = ChannelsUIState.Error
        }
    }
}