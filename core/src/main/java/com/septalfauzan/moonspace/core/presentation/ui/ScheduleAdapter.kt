package com.septalfauzan.moonspace.core.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.septalfauzan.moonspace.core.R
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.databinding.RocketRvItemBinding

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ListViewHolder>() {
    private var listData: List<RocketLaunchSchedule> = listOf()
    var onClick: (String) -> Unit = {}
    var bookmarkClicked: (String) -> Unit = {}

    fun setData(newData: List<RocketLaunchSchedule>){
        if(newData == null) return
        listData = newData
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = RocketRvItemBinding.bind(itemView)
        fun bind(data: RocketLaunchSchedule){
            with(binding){
                Glide.with(itemView.context).load(data.imageUrl).into(imageView)
                title.text = data.name
                agency.text = "-"
                timestamp.text = data.launchedAt
                bookmark.setImageResource( if(data.bookmarked) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24 )
            }
        }

        init {
            binding.root.setOnClickListener {
                onClick.invoke(listData[adapterPosition].id)
            }

            binding.bookmark.setOnClickListener{
                bookmarkClicked.invoke(listData[adapterPosition].id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rocket_rv_item, parent, false))
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }
}