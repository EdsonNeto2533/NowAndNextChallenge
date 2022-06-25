package com.mctable.nowandnextchallenge.dashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val channelsRepository: ChannelsRepository
) : ViewModel() {

    fun getChannels() {
        viewModelScope.launch {
            val aux = channelsRepository.getChannelsList(null)
        }
    }
}