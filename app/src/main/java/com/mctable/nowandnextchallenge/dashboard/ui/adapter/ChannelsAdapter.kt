package com.mctable.nowandnextchallenge.dashboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mctable.nowandnextchallenge.R
import com.mctable.nowandnextchallenge.dashboard.domain.model.ChannelModel
import com.mctable.nowandnextchallenge.databinding.ItemChannelCardBinding

class ChannelsAdapter : RecyclerView.Adapter<ChannelsAdapter.ProgramViewHolder>() {
    private val channelList = mutableListOf<ChannelModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_channel_card, parent, false)
        return ProgramViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        channelList[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = channelList.size

    fun loadItems(list: List<ChannelModel>) {
        channelList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProgramViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemChannelCardBinding.bind(itemView)

        fun bind(channelModel: ChannelModel) {
            binding.ivChannelBanner.load(channelModel.image) {
                placeholder(R.drawable.ic_loading_placeholder_svg)
            }
            binding.tvNextProgram.text = channelModel.nextProgram
            binding.tvNowPlaying.text = channelModel.nowPlaying
            binding.tvChannelCallLetter.text = channelModel.callLetter
        }
    }
}