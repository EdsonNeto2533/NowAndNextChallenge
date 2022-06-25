package com.mctable.nowandnextchallenge.dashboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.nowandnextchallenge.dashboard.domain.repository.ChannelsRepository
import com.mctable.nowandnextchallenge.dashboard.domain.usecase.GetChannelsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getChannelsListUseCase: GetChannelsListUseCase
) : ViewModel() {

    fun getChannels() {
        try {
            viewModelScope.launch {
                val aux = getChannelsListUseCase.getChannels(null)
                println(aux)
            }
        } catch (e: Exception) {
            println(e)
        }

    }
}