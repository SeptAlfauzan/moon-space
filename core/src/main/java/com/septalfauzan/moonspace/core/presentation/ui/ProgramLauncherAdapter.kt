package com.septalfauzan.moonspace.core.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.septalfauzan.moonspace.core.R
import com.septalfauzan.moonspace.core.databinding.ProgramRvItemBinding
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchProgram

class ProgramLauncherAdapter : RecyclerView.Adapter<ProgramLauncherAdapter.ListViewHolder>() {
    private var listData: MutableList<RocketLaunchProgram> = mutableListOf()

    fun setData(newData: List<RocketLaunchProgram>){
        val diffResult = DiffUtil.calculateDiff(ProgramLaunchDiffCallback(listData, newData))
        listData.clear()
        listData.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ProgramRvItemBinding.bind(itemView)
        fun bind(data: RocketLaunchProgram){
            with(binding){
                name.text = data.name
                desc.text = data.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.program_rv_item, parent, false))
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }
}


class ProgramLaunchDiffCallback(private val oldList: List<RocketLaunchProgram>, private val newList: List<RocketLaunchProgram>) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].name == newList[newItemPosition].name -> true
            oldList[oldItemPosition].desc == newList[newItemPosition].desc -> true
            else -> false
        }
    }
}