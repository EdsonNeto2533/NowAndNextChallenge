package com.mctable.nowandnextchallenge.dashboard.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mctable.nowandnextchallenge.R
import com.mctable.nowandnextchallenge.commons.views.ErrorBottomSheet
import com.mctable.nowandnextchallenge.commons.views.ErrorBottomSheetModel
import com.mctable.nowandnextchallenge.dashboard.ui.MainActivity
import com.mctable.nowandnextchallenge.dashboard.ui.adapter.ChannelsAdapter
import com.mctable.nowandnextchallenge.dashboard.ui.viewmodel.DashboardViewModel
import com.mctable.nowandnextchallenge.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding
    private val adapter = ChannelsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        binding = FragmentDashboardBinding.bind(view)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.channelList.observe(viewLifecycleOwner) {
            adapter.loadItems(it)
            binding.pbLoading.visibility = View.GONE
        }

        viewModel.setupRecyclerViewScrollListener.observe(viewLifecycleOwner) {
            setupScrollListener()
        }
    }

    private fun setupScrollListener() {
        binding.rvChannels.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && !recyclerView.canScrollVertically(1)
                    && binding.pbLoading.visibility == View.GONE
                ) {
                    viewModel.loadMore()
                    binding.pbLoading.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvChannels.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvChannels.adapter = adapter
    }
}